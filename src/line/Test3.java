package line;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test3 {

    public static void main (String[] args) throws java.lang.Exception
    {
        String inputL = "1 2 3 4 7";

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String inputL = br.readLine();
        String[] inputA = inputL.split(" ");

        String returnVal = "";

        int[] nums = new int[inputA.length-1];

        int target = Integer.parseInt(inputA[inputA.length-1]);

        for(int i =0 ; i < nums.length ; i ++){
            nums[i] = Integer.parseInt(inputA[i]);
        }

        int[] twoSumL = twoSum(nums, target);

        if(twoSumL != null){
            for(int twoSumI: twoSumL){
//                returnVal += " "+nums[twoSumI];
                returnVal += " "+twoSumI;
            }
            returnVal = returnVal.replaceFirst(" ","");
        }else{
            returnVal = "-1";
        }
        System.out.println(returnVal);
    }

    /**
     * 計算由那兩個數加總
     * @param nums 數字列隊
     * @param target 檢核數
     * @return 數字列隊所在位址
     */
    private static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i <nums.length ; i++){
            for(int j = i+1 ; j < nums.length ; j ++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}
