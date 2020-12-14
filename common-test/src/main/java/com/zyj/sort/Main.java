package com.zyj.sort;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(null);
        list.add(5);
        list.add(null);
        list.add(null);
        list.add(3);
        list.add(6);
        list.add(null);
        list.add(4);
        System.out.println("之前" + list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 写法1：
                if (o1 != null && o2 != null) {
                    return o1.compareTo(o2);
                } else {
                    return o1 == null ? 1 : -1;
                }
                // 写法2：
			/*return o1 == null ?
					1 :
					(o2 == null ? -1 : o1.compareTo(o2));*/
            }
        });
        System.out.println("之后" + list);

        String str ="1,2,3";
        System.out.println(Arrays.asList(str));

    }
}
