package com.test_tasks.task6;


import java.util.Arrays;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) {
        obeThread();
        twoThread();
    }

    public static void obeThread(){
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < arr.length; ++i){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("time " + (System.currentTimeMillis() - startTime));
    }
    public static void twoThread(){
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        float[] firstArray = new float[HALF];
        float[] secondArray = new float[HALF];
        long startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, firstArray, 0, HALF);
        System.arraycopy(arr, HALF, secondArray, 0, HALF);
        Thread fisrtThread  = new Thread (() -> {
            for(int i = 0; i < firstArray.length; ++i){
                firstArray[i] = (float)(firstArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread secondThread  = new Thread (() -> {
            for(int i = 0, j = HALF; i < secondArray.length; ++i, ++j){
                secondArray[i] = (float)(secondArray[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
            }
        });
        fisrtThread.start();
        secondThread.start();
        System.arraycopy(firstArray, 0, arr, 0, HALF);
        System.arraycopy(secondArray, 0, arr, HALF, HALF);

        System.out.println("time " + (System.currentTimeMillis() - startTime));
    }
}
