package leet.code;

import java.util.*;

/**
 * 74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean returnVal = false;

        LinkedHashMap<Integer,Integer> indexL = new LinkedHashMap<>();

        int indexN = 0;

        // 新增檢索陣列
        for(int[] matrixI: matrix){
            indexL.put(matrixI[0],matrixI[matrixI.length -1]);
        }


        //forEach
        for (Map.Entry<Integer, Integer> entry : indexL.entrySet()) {

            if(entry.getKey() <= target && target <= entry.getValue()){
                returnVal = (Arrays.stream(matrix[indexN]).filter(matrixI-> matrixI == target).count() > 0);
            }
            indexN ++ ;
        }
        return returnVal;
    }
}
