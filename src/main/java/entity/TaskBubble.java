package entity;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TaskBubble {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array2 = new int[5];

        for (int i = 0; i < 5; i++) {
            array2[i] = Integer.parseInt(reader.readLine());
        }
        sort(array2);
        for (int j = 0; j < array2.length; j++) {
            System.out.println(array2[j]);
        }
    }

    public static int[] sort(int[] array) {
        int a;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[j] > array[i]){
                    a = array[i];
                    array[i] = array[j];
                    array[j] = a;
                }
            }
        }
        return array;
    }
}