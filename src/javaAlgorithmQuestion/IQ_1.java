package javaAlgorithmQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IQ_1 {

    /** Question 1
     * Tasks array : [3, 4, 3, 2, 5]
     * CPU Cycle : 10
     *   According to the Shortest Task First rule,
     *   Task 3 (task given at index 3 of the array) has the lowest cycle time of 2, so it will be executed first.
     *   Then, Tasks 0 and 2 have the next lowest cycle of 3. Task 0 will be executed first due to the lower index rule.
     *
     *   And Task 2 will follow next.
     *   Accordingly at CPU cylcle 8 (2+3+3), Task 3, Task 0 and Task 2 will be completed.
     *   Next task will be Task1 with CPU cycle time 4. That means Task 1 will be running from cycle 9 until cycle 12.
     *   So we see that Task 1 is executing at cycle 10. Accordingly our function should return 1 as the response.
     *
     *   tasks:[3,10,20,1,2]	 cycle:15	    Return Value:1
     *   tasks:[3,10,10,20,1,2]	 cycle: 30	    Return Value:3
     */


    public static void main(String[] args) {

        Integer[] tasks = {3,10,20,1,2};
        Integer[] tasks2 = {3,10,10,20,1,2};
        Integer[] tasks3 = {3, 4, 3, 2, 5};

        System.out.println(getTaskIndexAtCycle(tasks3,10));
        System.out.println(getTaskIndexAtCycle(tasks2,0));
        System.out.println(getIndex(tasks, 15));
        System.out.println(getIndex(tasks2, 30));
        System.out.println(getIndex(tasks3, 10));
    }

    public static Integer getTaskIndexAtCycle(Integer[] tasks,Integer cycle){
        Integer index = 0;
        Integer resultCycle =0;

        Map<Integer,Integer> mapList = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            mapList.put(tasks[i],i); //3,0  10,1   20,2    1,3    2,4
        }

        Arrays.sort(tasks); //[1,2,3,10,20]

        for (int i = 0; i < tasks.length; i++) {
            resultCycle+= tasks[i];
            index = i;
            if (resultCycle>cycle){
                break;
            }
        }
        return mapList.get(tasks[index]);
    }

    //way2

    public static int getIndex(Integer [] arr, int cycle){

        ArrayList xArr=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            xArr.add(arr[i]);
        }

        Arrays.sort(arr);

        ArrayList newArry=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                newArry.add(arr[i]);
            }
        }

        Object o = newArry.get(cycle);

        return xArr.indexOf(o);
    }



}
