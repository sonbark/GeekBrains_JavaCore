package Lesson_3;

import java.util.Random;
import java.util.Scanner;

public class Class3 {

    static boolean isGameOver;
    static Scanner scanner = new Scanner(System.in);
    //static Scanner scanner2 = new Scanner(System.in);
    static Random random = new Random();

    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        method1();
        method2();
    }

    /*
    1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
    При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
    После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)
    */

    public static void method1(){

        System.out.println("========================================\nЗадача 1.\nЯ загадал число от 0 до 9\n");

        int userNumber;
        int flag = 1;

        while (flag == 1){
            isGameOver = false;

            int myNumber = random.nextInt(10);
            //System.out.println("Мое число: " + myNumber);
            System.out.println("Угадайте мое число");

            int i;
            for (i = 0; i<3; i++){

                userNumber = scanner.nextInt();
                scanner.nextLine();

                if (userNumber == myNumber){
                    System.out.println("\nПоздравляю! Вы угадали :)");
                    flag = checkInput();

                    if (flag == 0){
                        finish();
                        break;
                    } else {
                        i = 0;
                        break;
                        }
                } else if (userNumber > myNumber){
                    System.out.println("Ваше число больше загаданного");
                } else System.out.println("Ваше число меньше загаданного");
            }

            if (!isGameOver){
                if (i != 0){
                    if (flag == 0){
                        finish();
                        break;
                    } else {
                        System.out.println("\nВы не угадали!");
                        flag = checkInput();

                        if (flag == 0){
                            finish();
                            break;
                        }
                    }
                } else {
                    flag = 1;
                }
            } else {
                break;
            }
        }
    }

    public static boolean finish(){

        System.out.println("\nИгра закончена");
        isGameOver = true;
        //scanner.close(); //я решила не закрывать сканер, чтобы работала вторая задача
        return isGameOver;
    }

    public static int checkInput() {
        int x;
        do {
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            x = scanner.nextInt();
        } while (x < 0 || x > 1);
        scanner.nextLine();
        if (x==1){
            System.out.println("\nНовая игра!!!\n----------------------------------------");
        }
        return x;
    }


    /*
    2.* Создать массив из слов
    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
    "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
    "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с
    загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает
    буквы, которые стоят на своих местах.
    apple – загаданное
    apricot - ответ игрока
    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    Для сравнения двух слов посимвольно можно пользоваться:
    String str = "apple";
    char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    Играем до тех пор, пока игрок не отгадает слово.
    Используем только маленькие буквы.
     */

    public static void method2(){
        System.out.println("\n\n========================================\nЗадача 2.\nЯ загадал слово\n");

        int wordId = random.nextInt(words.length);
        String myWord = words[wordId];
        //System.out.println("Мое слово: " + myWord + "\n");

        /*
        не знала, что такое может быть, но как быть в ситуации, если метод уже запускается в условии,
        а тело цикла остается пустым?
         */
        while (guessing(myWord).contains("#")){
        }
        scanner.close();
    }

    public static String guessing(String myWord){
        System.out.println("Угадайте мое слово");
        String userWord = scanner.nextLine();

        String str = "";

        if(myWord.equals(userWord)){
            System.out.println("Поздравляю! Вы угадали мое слово");
             str = userWord;
        } else {
            if (myWord.length() < userWord.length()){
                for (int i = 0, j = 0; i < myWord.length(); i++, j++){
                    if (myWord.charAt(i) == userWord.charAt(j)){
                        str+=myWord.charAt(i);
                    } else {
                        str+="#";
                    }
                } int dif = 15-myWord.length();
                for (int i = 0; i<dif; i++){
                    str+="#";
                }
            } else {
                for (int i = 0, j = 0; i < userWord.length(); i++, j++){
                    if (myWord.charAt(j) == userWord.charAt(i)){
                        str+=myWord.charAt(i);
                    } else {
                        str+="#";
                    }
                } int dif = 15-userWord.length();
                for (int i = 0; i<dif; i++){
                    str+="#";
                }
            }
            System.out.println("Вы угадали буквы: " + str + "\nПопробуйте еще раз :)\n");
        }
        return str;
    }

//    public static boolean isNotSuccess(String str){
//        return str.contains("#");
//    }
//
//    public static boolean isSuccess (String myWord, String userWord){
//        return myWord.equals(userWord);
//    }
}
