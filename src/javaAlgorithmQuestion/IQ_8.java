package javaAlgorithmQuestion;

public class IQ_8 {

    /** Question 8
     * Any "(" parentheses that are opened within the given string must be closed.
     * Unopened parenthesis cannot be closed. And;
     * Any opened parenthesis must be closed.
     *      Example:
     *         (())     --> valid
     *         (()())   --> valid
     *         ((()())) --> valid
     *         ()()()   --> valid
     *         ()       --> valid
     *         ())()    --> invalid
     *         )()(     --> invalid
     *         ())()(   --> invalid
     */

    public static void main(String[] args) {


    }

    public static boolean isValid1(String str) {
        while (str.contains("()")){
            str=str.replace("()","");
        }
        return str.isEmpty();
    }

    public static boolean isvalid2(String str) {
        String newStr = str.trim().replace(" ","");
        while (newStr.contains("()")) {
            newStr = newStr.replace("()", "");
            if (newStr.equals("")) {
                break;
            }
        }
        if (newStr.equals("")){
            return true;
        }else return false;
    }

    public static boolean isvalid3(String str){
        str = str.replaceAll(" ","");

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(0)!='(') return false;
            if (str.length()%2==1) return false;
            str=str.replaceFirst("[(]","");
            str=str.replaceFirst("[)]","");
        }
        return true;
    }

    public static boolean isvalid4(String str){
        int count =0;
        char[] chars = str.toCharArray();
        for (char c : str.toCharArray()) { //chars yerine str.toCharArray(); yazdım. Genelde böyle istiyorlar.
            if (c=='('){
                count++;
            }if (c==')'){
                count--;
            }if (count<0){
                return false;
            }
        }
        return count==0; //sıfırdan büyükse bu konditionı sağlamadığı için(count sıfıra eşit olmadığı için) false döndürür.
    }

}
