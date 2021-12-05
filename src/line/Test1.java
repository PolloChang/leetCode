package line;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Problem Statement
 * You are given the horizontal and vertical lengths of a rectangle. Write a program that returns the area of the rectangle
 */
public class Test1 {

    /**
     * 計算面積，-1為超過計算精度
     * @param width 寬
     * @param height 高
     * @return 面積
     */
    public static int getArea(int width, int height){

        long returnVal;

        returnVal =  Long.valueOf(width) * Long.valueOf(height);

        if(returnVal >  Long.valueOf(2147483647)){
            returnVal = -1;
        }

        return (int)returnVal;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in).useRadix(10);
        int width = 1234;
        int height = 1234;

        System.out.println(getArea(width, height));
    }
}
