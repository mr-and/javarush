package com.javarush.task.task12.task1233;

/* 
Изоморфы наступают
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The index of the minimum element is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        int[] arr = Arrays.copyOf(array,array.length);
        Arrays.sort(arr);

        int x = -1;
        for (int i = 0; i < array.length; i++){
            if (arr[0]==array[i]){
                x = i;
            }
        }

        return new Pair<Integer, Integer>(arr[0], x);
    }


    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
