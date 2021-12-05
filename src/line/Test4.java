package line;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test4 {
    public static void main (String[] args) throws java.lang.Exception
    {

        String inputL = "3 0 1 1 2 2 0";
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String inputL = br.readLine();

        String[] inputA = inputL.split(" ");

        int nodes = Integer.parseInt(inputA[0]);

        int[] checkNL = new int[inputA.length-1];

        for(int i=1 ; i < inputA.length ;i++){
            checkNL[i-1] = Integer.parseInt(inputA[i-1]);
        }

        System.out.println(checkCycle(checkNL,nodes));
    }

    /**
     * 檢核數字陣列為圓形
     * @param checkNL 檢核數列
     * @param nodes 節點數
     * @return
     */
    private static String checkCycle(int[] checkNL,int nodes){

        boolean returnVal = true;

        if(checkNL == null){ //null 不成立圓形
            returnVal = false;
        }if((checkNL.length)/2 != nodes){// 不滿足檢核要求
            returnVal = false;
        }else{
            int previousN = -1;

            int startN = checkNL[0];


            for(int i= 0; i < checkNL.length ;i++){
                int checkNI = checkNL[0];
                if(i == 0){
                    startN = checkNI;
                }else if(checkNI != previousN){
                    returnVal = false;
                    break;
                }
                previousN = checkNI;
            }

             if(returnVal && previousN != startN){
                 returnVal = false;
             }
        }

        return Boolean.toString(returnVal);
    }
}
