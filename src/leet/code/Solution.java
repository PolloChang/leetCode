package leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1207. Unique Number of Occurrences
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique, or false otherwise.
 */
public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        boolean returnVal = true;

        int[] arrDistinctL = Arrays.stream(arr).distinct().toArray();

        List<Long> uniqueL = new ArrayList<>();

        long uniqueI;

        for (int arrDistinctI:arrDistinctL){

            uniqueI = Arrays.stream(arr).filter(arrI -> arrI == arrDistinctI).count();
            if(uniqueL.indexOf(uniqueI) == -1){
                uniqueL.add(uniqueI);
            }else{
                returnVal = false;
                break;
            }
        }

        return returnVal;
    }
}

/*
int min = arr[0], max = min;
        boolean res = true;
        // Getting min and max elements for space allocation.
        for (int i : arr) {
            if (i < min)
                min = i;
            else if (i > max)
                max = i;
        }

        // Allocating space for counter using min and max from last loop.
        // Also setting max to 0.
        int[] counter = new int[max - min + 1];
        max = 0;
//        Arrays.stream(counter).forEach(System.out::println);

//        System.out.println("========================");
        // Counting the elements from 'arr' array.
        // Also getting the max count in the same loop and storing in the 'max' variable.
        for (int i : arr) {
            int idx = i - min;
            counter[idx]++;
//            Arrays.stream(counter).forEach(System.out::println);
//            System.out.println("========================");
            if (counter[idx] > max)
                max = counter[idx];
        }

        // Generating a boolean[] checker using max variable.
        // This will be used to check whether all the counts are unique.
        boolean[] checker = new boolean[max + 1];

        // Checks through all the counts.
        // If the count appears for the first time, sets checker[e] t true.
        // If it appears again, breaks the loop and the result is false.
        for (int i : counter) {
            if (i != 0 && checker[i]) {
                res = false;
                break;
            }
            checker[i] = true;
        }
 */