package main;

import leet.code.Skiplist;

import java.util.*;

public class Main {


    public static void main(String [] args){

        long befort = System.currentTimeMillis();
        int[] nums = {3,3};

        int target = 6;

        int[] returnVal = null;

        for(int i = 0; i <nums.length ; i++){

            if(i!=0 && returnVal[1] != -1){
                break;
            }else{
                returnVal = new int[]{-1, -1};
                returnVal[0] = i;
            }

            System.out.println(nums[i]);

            for(int j = i+1 ; j < nums.length ; j ++){
                System.out.println(nums[j]);
                if(nums[i]+nums[j]==target){
                    System.out.println(27);
                    returnVal[1] = j;
                    break;
                }
            }
            System.out.println("====");
        }


        System.out.print(returnVal[0]);
        System.out.println(returnVal[1]);

        System.out.println((System.currentTimeMillis()-befort)/1000);
    }
}