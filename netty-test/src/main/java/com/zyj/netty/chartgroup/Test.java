package com.zyj.netty.chartgroup;

import java.util.Scanner;
public class Test {
//    public static void main(String[] args){
//        Scanner s1 = new Scanner(System.in);
//        int max = 0;
////       [[20,16],[9,10],[15,11],[10,9],[18,2]]
//       // [[20,16],[15,11],[10,9]]
//
//        // 读入的数组并讲数组转换为二位数组
//        String in = s1.nextLine();
//         in = in.replace("[","").replace("]", "");
//        String[] split = in.split(",");
//        int[][] nums = new int[split.length/2][2];
//        int mark = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums[i].length; j++) {
//                nums[i][j] = Integer.valueOf(split[mark].trim()) ;
//                mark ++;
//            }
//        }
//        // 根据二位数组，所有0下标元素进行排序
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i][0] < nums[j][0]){
//                    int temp0 = nums[i][0];
//                    int temp1 = nums[i][1];
//                    nums[i][0] = nums[j][0];
//                    nums[i][1] = nums[j][1];
//                    nums[j][0] = temp0 ;
//                    nums[j][1] = temp1;
//                }
//            }
//        }
//        System.out.printlnm(nums, 0)）++;
//
//
//
//    }
    // 递归处理
    public static  int  m(int[][] nums, int index){
        for (int i = index; i < nums.length; i++) {
            int temp = 0;
            for (int j = i +1; j < nums.length ; j++) {
                if (nums[i][0] > nums[j][0]){
                    if(nums[i][1] > nums[j][1]){
                        m(nums,j);
                    }
                }


            }

        }
        return 1;
    }

}






//package com.zyj.netty.chartgroup;
//
//
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Scanner;
//import java.util.Set;
//
//public class Test {
//
//    public static void main(String[] args){
//        // 保存输入句子截取后的单词词组，通过set去除重复
//        Set<String> set = new HashSet<>();
//        // 返回前缀匹配到的所有单词
//        Set<String> res = new HashSet<>();
//        String words = null;
//        String search = null;
//        StringBuilder sb = new StringBuilder();
//        Scanner s1 = new Scanner(System.in);
//        // 输入语句
//
//        while (s1.hasNext()){
//
//                words = s1.nextLine();
//
//                search = s1.nextLine();
//                break;
//
//        }
//        if (words != null && !"".equals(words)){
//            String[] split = words.split(" ");
//            for (String str :split){
//                set.addAll(instead(str));
//            }
//
//        }
//        // 模糊查询的单词
//
//        Iterator<String> iterator = set.iterator();
//        while (iterator.hasNext()){
//            String sss = iterator.next();
//            boolean b = sss.startsWith(search);
//            if (b){
//                res.add(sss);
//            }
//
//        }
//        if (res.size() == 0){
//            System.out.println(search);
//        }else {
//            Iterator<String> resIt = res.iterator();
//            while (resIt.hasNext()){
//                String sss = resIt.next();
//                sb.append(sss).append(" ");
//
//
//            }
//            System.out.println(sb.toString().trim());
//        }
//
//
//    }
//
//    /**
//     * 替换标点符号，返回单词数组
//     * @param str
//     * @return
//     */
//    public  static  Set<String> instead(String str){
//        Set<String> set = new HashSet<>();
//
//        String[] split  = str.replace("`", " ").replace(","," ").replace(".", " ").split(" ");
//        for (String s :split ){
//            set.add(s);
//        }
//        return set;
//
//    }
//}
//
////
////import java.util.ArrayList;
////import java.util.HashSet;
////import java.util.Iterator;
////import java.util.Scanner;
////import java.util.Set;
////
////public class Main {
////
////    public static void main(String[] args){
////        // 保存输入句子截取后的单词词组，通过set去除重复
////        Set<String> set = new HashSet<>();
////        // 返回前缀匹配到的所有单词
////        Set<String> res = new HashSet<>();
////        StringBuilder sb = new StringBuilder();
////        Scanner s1 = new Scanner(System.in);
////        // 输入语句
////        String words = s1.nextLine();
////        if (words != null && !"".equals(words)){
////            String[] split = words.split(" ");
////            for (String str :split){
////                set.addAll(instead(str));
////            }
////
////        }
////        Scanner s2 = new Scanner(System.in);
////        // 模糊查询的单词
////        String search = s2.nextLine();
////        Iterator<String> iterator = set.iterator();
////        while (iterator.hasNext()){
////            String sss = iterator.next();
////            boolean b = sss.startsWith(search);
////            if (b){
////                res.add(sss);
////            }
////
////        }
////        if (res.size() == 0){
////            System.out.println(search);
////        }else {
////            Iterator<String> resIt = res.iterator();
////            while (resIt.hasNext()){
////                String sss = resIt.next();
////                sb.append(sss).append(" ");
////
////
////            }
////            System.out.println(sb.toString().trim());
////        }
////
////
////    }
////
////    /**
////     * 替换标点符号，返回单词数组
////     * @param str
////     * @return
////     */
////public  static  Set<String> instead(String str){
////    Set<String> set = new HashSet<>();
////
////    String[] split  = str.replace("`", " ").replace(","," ").replace(".", " ").split(" ");
////    for (String s :split ){
////        set.add(s);
////    }
////    return set;
////
////}
////}
//
