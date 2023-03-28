package javaAlgorithmQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IQ_3 {

    /**Quesiton 3
     *This input: [1,2,2,2,3,4,4] give a result as output: [1,2,3,4]
     * */

    public static void main(String[] args) {

        Integer[] arr = {1,2,2,2,3,4,4};
        System.out.println(Arrays.toString(removeRepeats(arr))); //[1, 2, 3, 4]

    }

    public static Integer[] removeRepeats(Integer[] arr) {
        if (arr.length == 0) {
            return new Integer[0];
        }
        List<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        int lastItem = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (lastItem != arr[i]) {
                lastItem = arr[i];
                result.add(lastItem);
            }
        }
        return result.toArray(Integer[]::new);
    }


}
