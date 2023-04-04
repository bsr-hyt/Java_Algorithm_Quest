package javaAlgorithmQuestion;

public class IQ_7 {

    /** Question 7
     * In any programing language write an algorithm to calculate the result of the
     *     given formula in picture attached.
     *      - n: number of elements from given array
     *      - Xi : element from array with index i
     *      - you can see the picture in the java_ques.png file;
     * */

    public static void main(String[] args) {

        int[] array = {1, 2, 2, 3, 3, 3, 5, 7, 11, 15};
        System.out.println(addition(array));
        System.out.println(ratioExpoAndFactorial(array));

    }

    public static double addition(int[] array) {
        double[] faktor = new double[array.length];
        double result = 1;
        for (int i = 0; i < array.length; i++) {
            result = result * i;
            if (i == 0) {
                result++;
            }
            faktor[i] = result;
        }
//        System.out.println(Arrays.toString(faktor));
        double[] arrNew = new double[array.length];
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            arrNew[i] = (Math.pow(array[i], i)) / faktor[i];
            sum += arrNew[i];
        }
//        System.out.println(Arrays.toString(arrNew));
        return sum;
    }


    public static double ratioExpoAndFactorial(int[] arr){
        double result = 0;
        double expo;
        double factorial = 1;
        for (int i = 0; i < arr.length; i++) {
            expo = Math.pow(arr[i],i);
            if (i==0){
                factorial=1;
            }else {
                factorial*=i;
            }
            result+=expo/factorial;
        }
        return result;
    }

}
