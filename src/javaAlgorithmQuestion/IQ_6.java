package javaAlgorithmQuestion;

import java.util.Arrays;

public class IQ_6 {

    /** Question 6
     * There is a string of space-separated numbers;
     *      String str = "128 2 3693 65 89 25 10";
     * What is the method that redefines a string from smallest to largest by summing the numeric values of these numbers?
     * Result for this example:
     *      String result = "1 2 7 11 11 17 21";
     * */

    public static void main(String[] args) {
        System.out.println(sumOfStringNumber("128 2 3693 65 89 25 10"));

    }

    public static String sumOfStringNumber(String str) {
        String result = "";
        String[] array = str.split(" ");
        int[] array1 = new int[array.length];
        for (int i = 0; i < array1.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[i].length(); j++) {
//                sum+=Integer.parseInt(String.valueOf(array[i].charAt(j)));
                sum += Integer.parseInt(array[i].substring(j, j + 1));
            }
            array1[i] = sum;
        }
        Arrays.sort(array1);
        for (int i : array1) {
            result += i + " ";
        }
        return result.trim();
    }

}
