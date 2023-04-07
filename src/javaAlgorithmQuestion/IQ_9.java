package javaAlgorithmQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IQ_9 {

    /** Question 9
     * A string str contains a list of color names that are separated by a single space.
     *      Colors in str are mixed up, but each color has its original position at the end of the color name
     *      Given a str, with rearranged colors, sort the colors to the original state and return the original str
     * Constraints:
     *      str consists of multiple color name, spaces and digits from 1 to 9,
     *      str contains up to 9 color names,
     *      color name in str in are separated by a single space.
     * Example:
     *      String str1 = "red2 blue5 black4 green1 gold3"; --> output: green red gold black blue
     *      String str2 = "gold2 black1 white3";  --> output: black gold white
     */

    public static void main(String[] args) {
        String str1 = "red2 blue5 black4 green1 gold3            ";
        String str2 = "gold2 black1 white3";
        String str3 = "gold22 red22 black1 white120";

        System.out.println(orderColor(str1));
        System.out.println(orderColor(str2));

        System.out.println(orderColor2(str1));
        System.out.println(orderColor2(str2));

        System.out.println(orderColor(str1));
        System.out.println(orderColor(str2));

        System.out.println(orderColor3(str1));
        System.out.println(orderColor3(str2));

    }

    public static String orderColor(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(words[i].length() - 1) + words[i];
        }
        Arrays.sort(words); // --> stringe göre rakamları sıralar.
//         System.out.println(Arrays.toString(words));
        String result = "";
        for (String word : words) {
            result += word.replaceAll("[0-9]", "") + " "; // --> rakamları almaz.
//             result+=word.replaceAll("[^0-9]","")+" "; // -->  sadece rakamları alır.
        }
        return result;
    }

    public static String orderColor2(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (Integer.parseInt(words[i].replaceAll("[A-Za-z]", "")) > Integer.parseInt(words[j].replaceAll("[A-Za-z]", ""))) {
                    String temp = words[j];
                    words[j] = words[i];
                    words[i] = temp;
                }
            }
        }
        String result = String.join(" ", words).replaceAll("[0-9]", "");
        return result;
    }


    public static String orderColor3(String str) {
        String[] array = str.split(" ");
        int[] arrInt = new int[array.length];
        Map<String, Integer> mapList = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            mapList.put(array[i].substring(0, array[i].length() - 1), Integer.valueOf(array[i].substring(array[i].length() - 1)));
            arrInt[i] = mapList.get(array[i].substring(0, array[i].length() - 1));
        }
//        System.out.println(mapList.entrySet());
        Arrays.sort(arrInt);
        String result = "";
        for (int i = 0; i < arrInt.length; i++) {  //"red2 blue5 black4 green1 gold3"
            for (int j = 0; j < arrInt.length; j++) {
                if (arrInt[i] == mapList.get(array[j].substring(0, array[j].length() - 1))) {
                    result += array[j].substring(0, array[j].length() - 1) + " ";
                    break;
                }
            }
        }
        return result;
    }

}
