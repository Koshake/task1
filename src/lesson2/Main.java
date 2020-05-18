package lesson2;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // 1
        System.out.println("======== 1 ========");
        byte[] array1 = {0, 1, 1, 0, 1, 0, 1, 1};
        System.out.println("array before " + Arrays.toString(array1));
        swapOneZero(array1);
        System.out.println("array after  " + Arrays.toString(array1));

        // 2
        int[] array2 = new int[8];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i * 3;
        }
        System.out.println("======== 2 ========");
        System.out.println(Arrays.toString(array2));

        // 3
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] *= 2;
            }
        }
        System.out.println("======== 3 ========");
        System.out.println(Arrays.toString(array3));

        // 4
        int[][] array4 = new int[4][4];
        fillArray2D(array4);
        System.out.println("======== 4 ========");
        setMatrixDiagonal(array4);
        printArray2D(array4);

        // 5
        int[] array5 = new int[10];
        fillArray1D(array5);
        System.out.println("======== 5 ========");
        System.out.println(Arrays.toString(array5));
        System.out.println("Max: " + findMax(array5));
        System.out.println("Min " + findMin(array5));

        // 7
        int[] array7 = new int[5];
        fillArray1D(array7);
        System.out.println("======== 7 ========");
        System.out.println("before: " + Arrays.toString(array7));
        shiftArray(array7, -2);
        System.out.println("after:  " + Arrays.toString(array7));


    }

    public static void swapOneZero(byte[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else if (arr[i] == 0) {
                arr[i] = 1;
            }
        }
    }

    public static void fillArray2D(int[][] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(100);
            }
        }
    }

    public static void printArray2D(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void setMatrixDiagonal(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j || i + j == arr.length - 1) {
                    arr[i][j] = 1;
                }
            }
        }
    }

    public static void fillArray1D(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) - 20;
        }
    }

    public static  int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static  int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void shiftArray(int[] arr, int offset) {

        if(offset > 0) {
            for (int i = 0; i < offset; i++) {
                int temp = arr[0];
                for (int j = 1; j < arr.length; j++) {
                    arr[j-1] = arr[j];
                }
                arr[arr.length - 1] = temp;
            }
        }
        else {
            for (int i = 0; i < Math.abs(offset); i++) {
                int temp = arr[arr.length - 1];
                for (int j = arr.length - 2; j >= 0; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[0] = temp;
            }
        }

    }
}

