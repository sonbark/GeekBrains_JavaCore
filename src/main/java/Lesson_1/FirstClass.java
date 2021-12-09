package Lesson_1;

public class FirstClass {

    public static void main(String[] args) {

        //2. Создать переменные всех пройденных типов данных и инициализировать их значения

        short shortNum;
        shortNum = 1;

        int intNum = 2;

        long longNum = 3;

        float floatNum = 4.00f;

        double doubleNum = 5.00;

        char symbol = '6';

        String str = "7";

        boolean bool = true;


        System.out.println(method3(1,1,1,1));

        System.out.println(method4(1, 1));

        method5((short) 1);

        System.out.println(method6(1));

        method7("Никита");

        method8(2022);
    }

    /*
    3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    где a, b, c, d – аргументы этого метода, имеющие тип float.
    */

    public static float method3(float a, float b, float c, float d) { //+ нужно сделать проверку на d не равное нулю

        System.out.println("Задача 3");

        return a * (b + (c / d));
    }

    /*
    4. Написать метод, принимающий на вход два целых числа и проверяющий,
    что их сумма лежит в пределах от 10 до 20 (включительно),
    если да – вернуть true, в противном случае – false.
    */

    public static boolean method4(int a, int b){
        System.out.println("\nЗадача 4");

        int sum = a + b;

        boolean res;

        res = (sum >= 10) && (sum <= 20);

        return res;
    }

    /*
    5. Написать метод, которому в качестве параметра передается целое число,
    метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    Замечание: ноль считаем положительным числом.
     */

    public static void method5(short num){ //short - для разнообразия:)
        System.out.println("\nЗадача 5");

        String str;

        if (num<0){
            str = "Число отрицательное";
        } else {
            str = "Число положительное";
        }

        System.out.println(str);
    }

    /*
    6. Написать метод, которому в качестве параметра передается целое число.
    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
     */

    public static boolean method6(long a){
        System.out.println("\nЗадача 6");

        return (a<0);
    }

    /*
    7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
    Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    */

    public static void method7(String name){
        System.out.println("\nЗадача 7");

        System.out.println("Привет, " + name);
    }

    /*
     *8. Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
     Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */

    public static void method8(int year){
        System.out.println("\nЗадача 8");

        boolean bool;

        bool = (((year%4 == 0) && !(year%100 == 0)) || (year%400 == 0));

        if (bool){
            System.out.println(year + " - високосный год");
        } else {
            System.out.println(year + " - не високосный год");
        }
    }
}
