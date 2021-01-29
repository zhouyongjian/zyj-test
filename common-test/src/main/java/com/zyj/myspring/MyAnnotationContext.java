package com.zyj.myspring;

import com.zyj.myspring.anno.Autowired;
import com.zyj.myspring.anno.Component;
import com.zyj.myspring.anno.ComponentScan;
import com.zyj.myspring.anno.Scope;
import com.zyj.myspring.constant.ScopeType;
import com.zyj.myspring.definition.BeanDefinition;
import com.zyj.myspring.definition.BeanNameAware;
import com.zyj.myspring.definition.BeanPostProcessor;
import com.zyj.myspring.definition.InitializingBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyAnnotationContext {

    private Class config;

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    public MyAnnotationContext(Class config) throws  FileNotFoundException{
        this.config = config;

        List<Class> classList = scan(config);

        if (classList.size() > 0){
            for (Class clazz : classList){
                if (clazz.isAnnotationPresent(Component.class)){

                    if (BeanPostProcessor.class.isAssignableFrom(clazz)){
                        try{
                            beanPostProcessors.add((BeanPostProcessor) clazz.getDeclaredConstructor().newInstance());
                            continue;
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    BeanDefinition beanDefinition = new BeanDefinition();
                    Component component = (Component) clazz.getAnnotation(Component.class);
                    String beanName = component.value() !=null && !"".equals(component.value() ) ? component.value(): lowerFirstChar(clazz.getSimpleName());
                    beanDefinition.setBeanClass(clazz);
                    if (clazz.isAnnotationPresent(Scope.class)){

                        Scope scope = (Scope)clazz.getAnnotation(Scope.class);
                        beanDefinition.setScope(scope.value());
                    }else {
                        beanDefinition.setScope(ScopeType.SINGLETON);
                    }
                    beanDefinitionMap.put(beanName, beanDefinition);
                }
            }
        }
        instanceSingletonBean();//
        System.out.println(classList);

    }

    private void instanceSingletonBean(){
        for (String beanName : beanDefinitionMap.keySet()){
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if(ScopeType.SINGLETON.equals(beanDefinition.getScope())){
                if (!singletonObjects.containsKey(beanName)){
                    Object bean = doCreateBean(beanName, beanDefinition);
                    singletonObjects.put(beanName, bean);
                }
            }
        }

    }

    // 实例化bean
    private Object doCreateBean(String beanName, BeanDefinition beanDefinition){
        try {
            // 1.实例化
            Class beanClass = beanDefinition.getBeanClass();
            Object o = beanClass.getDeclaredConstructor().newInstance();

            // 2.属性tianchon个
            Field[] declaredFields = beanClass.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.isAnnotationPresent(Autowired.class)){
                    field.setAccessible(true);
                    field.set( o, getBean(field.getName()));
                }
            }

            // 3. aware
            if (o instanceof BeanNameAware){
                ((BeanNameAware) o) .setBeanName(beanName);
            }

            // 前置增强
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                o = beanPostProcessor.postProcessBeforeInitialization(o, beanName);
            }

            // 4.初始化
            if (o instanceof InitializingBean){
                ((InitializingBean) o) .afterPropertiesSet();
            }

            // 后置增强
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                o = beanPostProcessor.postProcessAfterInitialization(o, beanName);
            }
            return o;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    private List<Class> scan(Class config) throws FileNotFoundException {
        List<Class> classList = new ArrayList<>();
        ComponentScan annotation = (ComponentScan) config.getAnnotation(ComponentScan.class);
        String path = annotation.value();
        path = path.replace(".", "/");
        ClassLoader classLoader = MyAnnotationContext.class.getClassLoader();
        URL resource = classLoader.getResource(path);
        if (resource == null){
            throw new FileNotFoundException(path+ "路径不存在");
        }
        System.out.println("CompentScan path = " + resource.getPath());

        File file = new File(resource.getFile());
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files){
                String absolutePath = f.getAbsolutePath();
                absolutePath = absolutePath.substring(absolutePath.indexOf("com",absolutePath.indexOf("com")+1), absolutePath.indexOf(".class"));
                absolutePath = absolutePath.replace("/", ".");
                try{

                    classList.add(classLoader.loadClass(absolutePath));
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }

            }

        }else {
            throw new FileNotFoundException(resource.getPath()+ "不是一个文件夹");
        }
        return classList;
    }


    public Object getBean(String beanName){
        Object res  = null;
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition != null){
            if (ScopeType.SINGLETON.equals(beanDefinition.getScope())){
                res = singletonObjects.get(beanName);
                if (res == null){
                    res = doCreateBean(beanName, beanDefinition);
                    singletonObjects.put(beanName, res);
                }
            }else if (ScopeType.PROTOTYPE.equals(beanDefinition.getScope())){
                res = doCreateBean(beanName, beanDefinition);

            }
        }
        return  res;
    }

    /**
     * 将类名首字母小写
     * @param str
     * @return
     */
    private String lowerFirstChar(String str){
        char [] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
