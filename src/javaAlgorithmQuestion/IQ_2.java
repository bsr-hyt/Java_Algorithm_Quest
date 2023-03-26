package javaAlgorithmQuestion;

public class IQ_2 {


    /**Question 2
     * Write a method that takes 2 integers as strings and adds these two integers and returns a string.
     *Example:str1= "234567543435";    str2="894784947849";
     *Result:"11293524991284"
     */

    public static void main(String[] args) {

        System.out.println(sumStrings("234567543435", "894784947849"));
        System.out.println(sumStrings("3717080719845894584895454456356203", "23377847479527435723757235723755638872"));

    }

    public static String sumStrings(String str1, String str2) {
        int max = Math.max(str1.length(), str2.length());
        int min = Math.min(str1.length(), str2.length());
        String result = "";
        int sum;

        if (str1.length() < str2.length()) {
            for (int i = 0; i < max - min; i++) {      //  12345   00012
                str1 = "0" + str1;
            }
        } else if (str1.length() > str2.length()) {
            for (int i = 0; i < max - min; i++) {
                str2 = "0" + str2;
            }
        }
        int kalan = 0;
        for (int i = str1.length() - 1; i >= 0; i--) {

            sum = Integer.parseInt(Character.toString(str1.charAt(i)))
                    + Integer.parseInt(Character.toString(str2.charAt(i)));
            sum += kalan;
            kalan = 0;
            if (sum <= 9) {
                result = sum + result;
                kalan = 0;
            } else {
                result = sum % 10 + result;
                kalan++;
            }
        }

        if (kalan > 0) result = kalan + result;

        return result;
    }




}
