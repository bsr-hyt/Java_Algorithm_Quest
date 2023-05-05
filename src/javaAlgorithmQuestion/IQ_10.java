package javaAlgorithmQuestion;

public class IQ_10 {

    /**
     * Given a string, look for a mirror image(backwards) string at both the beginning and end of
     * the given string. In other words, zero or more characters at the very beginning of the given
     * string, and at the very end of the string in reverse order(possibly overlapping).
     * For example, the string "abXYZba" has the mirror end "ab".

     * In birefly, look for a mirror image string at both the beginning and end of the given string.
     mirrorEnds("abXYZba")         --> "ab"
     mirrorEnds("abca")            --> "a"
     mirrorEnds("aba")             --> "aba
     mirrorEnds("abab")            --> ""
     mirrorEnds("xxx")             --> "xxx"
     mirrorEnds("xxYxx")           --> "xxYxx"
     mirrorEnds("Hi and iH")       --> "Hi"
     mirrorEnds("x")               --> "x"
     mirrorEnds("")                --> ""
     mirrorEnds("123and then 321") --> "123"
     mirrorEnds("band andab")      --> "ba"
     */

    public static void main(String[] args) {

        System.out.println(mirrorEnds("abXYZba")); //"ab"
        System.out.println(mirrorEnds("abca")); //a
        System.out.println(mirrorEnds("aba")); //aba
        System.out.println(mirrorEnds("abab")); //""
        System.out.println(mirrorEnds("xxx")); //xxx
        System.out.println(mirrorEnds("xxYxx")); //xxYxx
        System.out.println(mirrorEnds("Hi and iH")); //Hi
        System.out.println(mirrorEnds("x")); //x
        System.out.println(mirrorEnds("")); //""
        System.out.println(mirrorEnds("123and then 321")); //123
        System.out.println(mirrorEnds("band andab")); //ba
        System.out.println(mirrorEnds("xy")); //""
        System.out.println(mirrorEnds("xyxyZyxyx")); //xyxy
        System.out.println(mirrorEnds("kayak")); //kayak
        System.out.println(mirrorEnds("aktayajka")); //ak

        System.out.println(mirrorEnds2("abXYZba")); //"ab"
        System.out.println(mirrorEnds2("abca")); //a
        System.out.println(mirrorEnds2("aba")); //aba
        System.out.println(mirrorEnds2("abab")); //""
        System.out.println(mirrorEnds2("xxx")); //xxx
        System.out.println(mirrorEnds2("xxYxx")); //xxYxx
        System.out.println(mirrorEnds2("Hi and iH")); //Hi
        System.out.println(mirrorEnds2("x")); //x
        System.out.println(mirrorEnds2("")); //""
        System.out.println(mirrorEnds2("123and then 321")); //123
        System.out.println(mirrorEnds2("band andab")); //ba
        System.out.println(mirrorEnds2("xy")); //""
        System.out.println(mirrorEnds2("xyxyZyxyx")); //xyxy
        System.out.println(mirrorEnds2("kayak")); //kayak
        System.out.println(mirrorEnds2("aktayajka")); //ak

        System.out.println(reverseWord("kayak")); //kayak

    }
    public static String mirrorEnds(String str) {
        String strOrjinal = str;
        String strNew = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(0, 1).equals(str.substring(str.length() - 1))) {
                strNew += str.substring(0, 1);
                str = str.replace(str.substring(0, 1), "");
            }
        }
        if (str.length() > 1) {
            return strNew;
        } else if (str.length() == 1) {
            return strOrjinal;
        } else if (strNew.length() == 1 && str.equals("")) {
            return strOrjinal;
        } else return "";
    }

    public static String mirrorEnds2(String str) {
        String result = "";
        if (str.equals(new StringBuffer(str).reverse().toString())) {
            return str;
        }
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
                result += str.charAt(i);
            } else {
                break;
            }
        }
        return result;
    }

    public static String reverseWord(String str) {
        String reverse = "";
        for (int i = str.length(); i >= 0; i--) {
            reverse += str.charAt(i);
        }
        return reverse;
    }




}
