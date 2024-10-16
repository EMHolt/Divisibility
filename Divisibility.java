/**
 * Author:      Jack Pender
 * Date:        October 2024
 * Class:       APCSA
 * Description: Reads 4 numbers from a text file, finds the GCF of
 *              the first two numbers, then finds the LCM of the
 *              last two numbers.
 */

import java.io.*;
import java.util.*;

public class Divisibility {
    public static void main(String[] a) throws FileNotFoundException {
        int[] intArr = readTxt();

        int int1 = intArr[0];
        int int2 = intArr[1];
        int int3 = intArr[2];
        int int4 = intArr[3];

        System.out.println(int1 + " " + int2 + " " + int3 + " " + int4);

        int gcf = gcf(int1, int2);

        System.out.println(gcf);

        int gcf2 = gcf(int3, int4);
        int lcm  = lcm(int3, int4, gcf2);

        System.out.println(lcm);

    }

    /**
     * Reads the text file, throws and exception if necessary, the
     * text is stored in an array and is returned.
     * @return
     * @throws FileNotFoundException
     */
    public static int[] readTxt() throws FileNotFoundException {
        FileReader reader;
        String fileInputName = "ints.txt";
        Scanner scan = null;

        scan = new Scanner(new BufferedReader(new FileReader(fileInputName)));
        int int1 = scan.nextInt();
        int int2 = scan.nextInt();
        int int3 = scan.nextInt();
        int int4 = scan.nextInt();

        int[] intArr = {int1, int2, int3, int4};

        return intArr;
    }

    /**
     * Uses Euclid's GCF algorithm to calculate the GCF
     * given two numbers.
     * @param int1
     * @param int2
     * @return
     */
    public static int gcf(int int1, int int2) {
        int gcf = -1;
        int remainder = -1;
        boolean done = false;

        while(!done) {
            remainder = int1 % int2;
            if(remainder == 0) {
                break;
            }
            int1 = int2;
            int2 = remainder;
        }

        gcf = int2;

        return gcf;
    }

    /**
     * Given 2 numbers and a gcf between those two numbers,
     * the method uses the LCM formula to return the LCM
     * of the 2 numbers.
     * @param int1
     * @param int2
     * @param gcf
     * @return
     */
    public static int lcm(int int1, int int2, int gcf) {
        int lcm = (int1 * int2) / gcf;
        return lcm;
    }
}
