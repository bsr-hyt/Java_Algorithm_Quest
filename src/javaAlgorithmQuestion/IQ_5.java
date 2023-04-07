package javaAlgorithmQuestion;

import java.util.ArrayList;
import java.util.List;

public class IQ_5 {

    /** Question 5
     * In this challenge, we want to iterate through on the characters of the input string and check whether the number of the
     *      occurrences for each character is equal. For example, "abcde" is a valid string, on the other hand,
     *      "abcdeee" is not because count of 'e' is 3, not 1 as the others.
     *      Moreover, we have chance to remove only one character from the string in order to make it valid.
     *      Think of a scenario: "xyzz" is given to us, and we should remove one of these 'z' characters.
     *      In this case, we can assume that the string is valid since each existing characters exist only single time after the removal operation.
     * Specification
     *      .isValid(str)--->Method Name
     *      Decide the given string is valid in terms of character counts including possibility of one character removal
     * Parameters
     *      str: String - input to be searched
     * Return Value
     *      boolean - final decision about that string, true or false
     * Constraints
     *      Input string consists of English alphabet characters
     *      All characters are lowercase
     * Examples:
     *      "cac" => true - we can get rid of one these 'c' chars
     *      "aabcc" => true - if we remove 'b', then it is ok
     *      "efgh" => true - we even don't need to use remove operation
     *      "mumukkpp" => true - all of them occurred twice
     *      "pppenm" => false - even tough we delete one 'p', that is not enough, still one more 'p' exists
     *      "ekekua" => false - we can either remove 'u' or 'a', but in any case, the remaining one breaks the rule
     */

    public static void main(String[] args) {

        System.out.println(isValid("cac"));
        System.out.println(isValid("aabcc"));
        System.out.println(isValid("efgh"));
        System.out.println(isValid("mumukkpp"));
        System.out.println(isValid("pppenm"));
        System.out.println(isValid("ekekua"));
        System.out.println(isValid("adddcccggg"));
        System.out.println(isValid("aaaadddccc"));
        System.out.println(isValid("ddddccccaaa"));
        System.out.println(isValid("ddddccccaaaaa"));
        System.out.println(isValid("aaaadddvvvsss"));

    }

    public static boolean isValid(String str) {
        String str1 = str.toLowerCase();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < str1.length(); ) {
            String control = str1.substring(0, 1);
            int count = str1.length() - str1.replace(control, "").length();
            list.add(count);
            str1 = str1.replace(control, "");
        }
        if (list.stream().distinct().count() == 1) {
            return true;
        }

        for (int i = 0; i < str.length(); i++) {
            String newStr = str.substring(0, i) + str.substring(i + 1);

            List<Integer> list2 = new ArrayList<>();

            for (int j = 0; j < newStr.length(); ) {
                String control = newStr.substring(0, 1);
                int count = newStr.length() - newStr.replace(control, "").length();
                list2.add(count);
                newStr = newStr.replace(control, "");
            }

            if (list2.stream().distinct().count() == 1) {
                return true;
            }
        }
        return false;
    }

}
