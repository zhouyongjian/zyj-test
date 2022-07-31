package com.zyj;
public class Solution {

    public static void main(String[] args){
        int[]temp  = new int[]{1,3,1,-1,3};
        System.out.println(singleNumber(temp));
    }

    public static int singleNumber(int[] nums) {
        int [] indexs = new int[nums.length - 1];
        int index = 0;
        for(int i = 0;i<nums.length;i++){
            if(i == nums.length -1){
                return nums[nums.length - 1];
            }

            boolean isInIndexs = false;
            if(i != 0){
                for(int z = 0;z<indexs.length;z++){
                    if(i == indexs[z]){
                        isInIndexs = true;
                        break;
                    }
                }

            }
            if(i != 0 && isInIndexs){
                continue;
            }
            boolean flag = false;
            for(int j = i+1;j<nums.length;j++){
                if(nums[i] == nums[j]){
                    indexs[index] = j;
                    index ++;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                return nums[i];
            }
        }
        return 0;
    }


}