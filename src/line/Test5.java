package line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Test5 {

    public static void main (String[] args) throws java.lang.Exception
    {
        String inputL = "2 1 2 -1 3";

        String[] inputA = inputL.split(" ");

        long target = Integer.parseInt(inputA[0]);


        long[] checkNL = new long[inputA.length-1];

        for(int i=1 ; i < inputA.length ;i++){
            checkNL[i-1] = Integer.parseInt(inputA[i-1]);
        }

        List<Long> retruenVal = streamN(checkNL, target);


        retruenVal.stream().forEach(retruenValI -> System.out.print(retruenValI+" "));

    }

    /**
     * 解析
     * @param checkNL 檢核數列
     * @param target 數列容量
     * @return
     */
    private static List<Long> streamN(long[] checkNL, long target){
        List<Long> returnVal = null;

        List<Long> contentL = new ArrayList<>();



        if(0 < target && target <= 3_000_000_000L){//the window size W will be an integer in the range, 0 < W ≦ 3,000,000,000.

            //1. 列出所有的數字

            long[] arrDistinctL = Arrays.stream(checkNL).distinct().toArray();

            //2. 排序

            long temp;

            for (int i = 0; i < arrDistinctL.length; i++) {
                for (int j = i + 1; j < arrDistinctL.length; j++) {
                    if (arrDistinctL[i] < arrDistinctL[j]) {
                        temp = arrDistinctL[i];

                        arrDistinctL[i] = arrDistinctL[j];

                        arrDistinctL[j] = temp;

                    }

                }
            }

            //3. 只取前面 target 個數

            for(long checkNI : checkNL){
                for (int i = 0; i < target; i++) {

                    long nu = arrDistinctL[i];

                    if(checkNI == nu){
                        contentL.add(checkNI);
                    }
                }

            }


            returnVal = contentL;
        }else{
            returnVal = null;
        }

        return returnVal;
    }




}
