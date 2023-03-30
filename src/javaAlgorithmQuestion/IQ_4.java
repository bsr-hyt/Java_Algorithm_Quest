package javaAlgorithmQuestion;

import java.util.HashMap;
import java.util.Map;

public class IQ_4 {

    /** Question 4
     *  Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * Symbol       Value
     *         I             1
     *         V             5
     *         X             10
     *         L             50
     *         C             100
     *         D             500
     *         M             1000
     *  For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII,
     *         which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
     *         Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
     *         The same principle applies to the number nine, which is written as IX.
     *         There are six instances where subtraction is used:
     * I can be placed before V (5) and X (10) to make 4 and 9.
     *         X can be placed before L (50) and C (100) to make 40 and 90.
     *         C can be placed before D (500) and M (1000) to make 400 and 900.
     *         Given a roman numeral, convert it to an integer.
     * Example 1:
     *         Input: s = "III"
     *         Output: 3
     *         Explanation: III = 3.
     *         Example 2:
     *
     *         Input: s = "LVIII"
     *         Output: 58
     *         Explanation: L = 50, V= 5, III = 3.
     *         Example 3:
     *
     *         Input: s = "C"
     *         Output: 1994
     *         Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     *
     *         Constraints:
     *         1 <= s.length <= 15
     *         s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
     *         It is guaranteed that s is a valid roman numeral in the range [1, 3999].
     */

    public static void main(String[] args) {

        //way1
        RomanToNumber ob = new RomanToNumber();
        // Considering inputs given are valid
        String str = "MCMIV";
        System.out.println("Integer form of Roman Numeral" + " is " + ob.romanToDecimal(str));

        //way2
        RomanToNumber.romanToInt("MCMIV");
        RomanToNumber.romanToInt("LVIII");
        RomanToNumber.romanToInt("MCMXCIV");
        RomanToNumber.romanToInt("II");
        RomanToNumber.romanToInt("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        RomanToNumber.romanToInt("MMMMMMMMMMMM");

    }

    //way 1***
    public static class RomanToNumber {
        // This function returns
        // value of a Roman symbol
        static int value(char r) {
            if (r == 'I')
                return 1;
            if (r == 'V')
                return 5;
            if (r == 'X')
                return 10;
            if (r == 'L')
                return 50;
            if (r == 'C')
                return 100;
            if (r == 'D')
                return 500;
            if (r == 'M')
                return 1000;
            return -1;
        }

        // Finds decimal value of a
        // given roman numeral
        static int romanToDecimal(String str) {
            // Initialize result
            int res = 0;

            for (int i = 0; i < str.length(); i++) {
                // Getting value of symbol s[i]
                int s1 = value(str.charAt(i));

                // Getting value of symbol s[i+1]
                if (i + 1 < str.length()) {
                    int s2 = value(str.charAt(i + 1));

                    // Comparing both values
                    if (s1 >= s2) {
                        // Value of current symbol
                        // is greater or equalto
                        // the next symbol
                        res = res + s1;
                    } else {
                        // Value of current symbol is
                        // less than the next symbol
                        res = res + s2 - s1;
                        i++;
                    }
                } else {
                    res = res + s1;
                }
            }
            return res;
        }

        //way2***
        public static void romanToInt(String s) {
            Map<Character, Integer> translations = new HashMap<Character, Integer>();

            //Adding elements to map
            translations.put('I', 1);
            translations.put('V', 5);
            translations.put('X', 10);
            translations.put('L', 50);
            translations.put('C', 100);
            translations.put('D', 500);
            translations.put('M', 1000);

            s = s.replace("IV", "IIII");
            s = s.replace("IX", "VIIII");
            s = s.replace("XL", "XXXX");
            s = s.replace("XC", "LXXXX");
            s = s.replace("CD", "CCCC");
            s = s.replace("CM", "DCCCC");

            int number = 0;
            if (s.length() <= 15 && 1 <= s.length()) {
                for (int i = 0; i < s.length(); i++) {
                    number += translations.get(s.charAt(i));
                }
                if (number >= 1 && number <= 3999) {
                    System.out.println(number);
                } else {
                    System.out.println("roma rakamının sayıya çevrilmiş hali 3999 u aşıyor.");
                }
            } else {
                System.out.println("girdiğiniz roma rakamalrının uzunluğu 15'i aşıyor.");
            }
        }
    }

}
