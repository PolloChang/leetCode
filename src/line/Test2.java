package line;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Test2 {

    private int size ;




    public static void main (String[] args) throws java.lang.Exception
    {

        String inputL = "6 2 OFFER 1 OFFER Hello OFFER 3 SIZE TAKE TAKE";



//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();

        String[] inputA = inputL.split(" ");
        String take = null;
        int takeN = 0;

        int offerLength = Integer.parseInt(inputA[0]);

        int offerInput = 0;
        String[] offerL;

        offerL = new String[offerLength];

        for(int i = 2; i < inputA.length ; i ++){
            String input = inputA[i];

            if(input.equals("OFFER") && offerInput <= offerLength -1 ){
                offerL[offerInput] = inputA[i+1];
                offerInput ++;
                i ++;
                System.out.println(true);
            }else if(input.equals("OFFER") && offerInput > offerLength -1 ){
                System.out.println(false);
            }else if(input.equals("SIZE")){
                long count = 0;
                count = Arrays.stream(offerL).filter(offerI -> offerI.equals(take)).count();
                System.out.println(count);
            }else if(input.equals("TAKE")){

                if(takeN < offerL.length){
                    System.out.println(offerL[takeN]);
                }
                takeN ++;
            }
        }



//        System.out.println(input);
    }
}
