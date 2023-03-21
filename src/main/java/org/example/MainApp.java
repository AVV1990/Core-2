package org.example;


import java.util.Arrays;


public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        int size = 10_000_000;

        float [] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        float [] arr2 = new float[size];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = 1.0f;
        }


        firstMethod(arr);
        secondMethod(arr2);

    }

    public static void firstMethod (float [] arr){

      long startTime = System.currentTimeMillis();

      for (int i = 0; i < arr.length; i++) {
          arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
      }
      System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms." );

    }

    public static void secondMethod(float [] arr2) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        float [] leftHalfArr = new float[arr2.length/2];
        float [] rightHalfArr = new float[arr2.length/2];

        System.arraycopy(arr2,0,leftHalfArr,0,arr2.length/2);
        System.arraycopy(arr2,arr2.length/2,rightHalfArr,0,arr2.length/2);


        Thread tread1 = new Thread(()->{
            for (int i = 0; i < leftHalfArr.length; i++) {
                leftHalfArr[i] = (float)(leftHalfArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }

        });

        Thread tread2 = new Thread(()->{
            int number = arr2.length/2;
            for (int i = 0; i < rightHalfArr.length; i++) {
                rightHalfArr[i] = (float)(rightHalfArr[i] * Math.sin(0.2f +  number / 5) * Math.cos(0.2f +  number / 5) * Math.cos(0.4f +  number / 2));
                number++;
            }

        });
        tread1.start();
        tread2.start();

        tread1.join();
        tread2.join();



        System.arraycopy(leftHalfArr,0,arr2,0,arr2.length/2 );
        System.arraycopy(rightHalfArr,0,arr2, arr2.length/2,arr2.length/2);


        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms." );

    }




}
