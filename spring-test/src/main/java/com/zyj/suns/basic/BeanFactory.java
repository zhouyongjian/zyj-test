package com.zyj.suns.basic;

import com.zyj.util.ClassUtil;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {

    private static Properties env = new Properties();
    static {
        InputStream input = null;
        try {
            input=BeanFactory.class.getClassLoader().getResourceAsStream("suns/sun.properties");
            env.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static UserService getUserService(){
//        return new UserServiceImpl();
        UserService userService = null;
        Class clazz = null;
        try {
            clazz = Class.forName(env.getProperty("userService"));
            userService  = (UserService)clazz.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return userService;
    }

    public static UserDao getUserDao(){
        UserDao userDao = null;
        Class clazz = null;
        try {
            clazz = Class.forName(env.getProperty("userDao"));
            userDao  = (UserDao)clazz.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return userDao;
    }

    public static Object getInstance(String key){

        Object res = null;
        Class clazz = null;
        try {
            clazz = Class.forName(env.getProperty(key));
            res  = clazz.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 泛型版本
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T>T getInstanceStong(Class clazz){

        T res = null;
        try {
            clazz = Class.forName(env.getProperty(ClassUtil.lowerFirstChar(clazz.getSimpleName())));// 首字母小写
            res  = ((T) clazz.newInstance());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }


}