package Lesson_2;

import java.util.Arrays;
import java.util.Random;

public class MyClass {
    public static void main(String[] args) {

        int[] arr = {0,0,1};
        int[] arr6 = {1, 1, 1, 2, 1};
        int[] arr7 = {0, 1, 2, 3};
        method1(arr);
        method2();
        method3();
        method4();
        method5();
        System.out.println(method6(arr6));
        //method7(arr7, 1);
    }

    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /*
    1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    public static void method1(int[] arr){
        System.out.println("Задача 1");

        for (int i = 0; i<arr.length; i++){
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {arr[i] = 0;}
        }
        printArray(arr);
    }

    /*
    2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     */
    public static void method2(){
        System.out.println("\n\nЗадача 2");

        int[] arr = new int[8];

        int i = 0;
        while (i<8) {
            arr[i] = (i*3);
            i++;
        }

        printArray(arr);
    }

    /*
    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    public static void method3(){
        System.out.println("\n\nЗадача 3");

        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i<arr.length; i++){
            if (arr[i]<6){
                arr[i]*=2;
            }
        }
        printArray(arr);
    }

    /*
    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами
     */
    public static void method4(){
        System.out.println("\n\nЗадача 4");

        int[][] arr2 = new int[10][10];

        for (int i = 0; i<10; i++){
            for (int j = 0; j<10; j++){
                if (i == j || i + j == 9){
                    arr2[i][j] = 1;
                } else {arr2[i][j] = 0;}
            }
        }

        for (int[] i : arr2){
            printArray(i);
            System.out.println();
        }
    }

    /*
    5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
     */
    public static void method5(){
        System.out.println("\nЗадача 5");

        int[] arr = new int[10];
        Random random = new Random();

        for (int i = 0; i<arr.length; i++){
            arr[i] = random.nextInt(10);
        }
        printArray(arr);

        int min = 10;
        int max = -1;
        int maxId = 0;
        int minId = 0;

        for (int i = 0; i< arr.length; i++){
            if (arr[i] > max) {
                max = arr[i];
                maxId = i;
            }

            if (arr[i] < min) {
                min = arr[i];
                minId = i;
            }
        }

        System.out.printf("\nMax = %s, min = %s", arr[maxId], arr[minId]);
    }

    /*
     6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1])
     * → true, граница показана символами ||, эти символы в массив не входят.
     */
    public static boolean method6(int[] arr){
        System.out.println("\n\nЗадача 6");

        boolean bool = false;
        int sum1 = 0;
        int sum2;

        for (int i = 0; i<arr.length; i++){
            sum2 = 0;

            sum1 += arr[i];
            for (int j = i + 1; j < arr.length; j++){
                sum2 += arr[j];
            }
            if (sum1 == sum2) {
                bool = true;
            }
        }
        return bool;
    }

    /*
    7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
    Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    При каком n в какую сторону сдвиг можете выбирать сами.
     */
//    public static void method7(int[] arr, int n){
//        System.out.println("\nЗадача 7");
//        printArray(arr);
//
//        int x = arr[0];
//        int y = 0;
//
//        for (int i = 0; i<arr.length; i++){
////            if (i+n > arr.length){
////                x = arr[i];
////                arr[i] = arr[i+1];
////            }
//
//            if (i+n < arr.length){
//                x = arr[i];
//                arr[i] = x;
//            } else {
//
//            }
//
//
//            //берем а - сохраняем а - переходим на б - берем б - сохраняем б - б=а
//
//        }
//
//
//        System.out.println(Arrays.toString(arr));
//    }

//Я не решила...
// Объясните, пожалуйста:)
}
