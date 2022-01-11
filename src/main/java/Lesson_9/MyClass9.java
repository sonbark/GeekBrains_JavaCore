package Lesson_9;

public class MyClass9 {

    /*
    1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
    2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
    должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
    3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
    и вывести результат расчета.
    */

    public static void main(String[] args) throws MyArrayException {

        String[][] arr01 = {{"0", "1", "2", "3"}, {"4", "5", "6", "7"}, {"i", "j", "k", "l"}, {"12", "13", "14", "15"}};
        String[][] arr02 = new String[2][2];
        String[][] arr03 = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

        try {
            method(arr03);
        }
        catch (MyArraySizeException e){
            e.printStackTrace();
        }
        catch (MyArrayDataException e){
            e.printStackTrace();
        }
    }

    static void method(String[][] arr) throws MyArrayException {
        int total = 0;
        int x;

        if (arr.length == 4 && arr[0].length == 4) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {

                    try {
                        x = Integer.parseInt(arr[i][j]);
                    } catch (Exception e) { //Можно так? Для этого ведь уже есть исключение
                        throw new MyArrayDataException(i, j);
                    }
                    total += x;
                }
            }
            System.out.println("Сумма чисел: " + total);
        } else {
            throw new MyArraySizeException(arr.length, arr[0].length);
        }
    }
}

abstract class MyArrayException extends Exception { }

class MyArraySizeException extends MyArrayException{

    int arrSizeX, arrSizeY;

    public MyArraySizeException(int arrSizeX, int arrSizeY) {
        this.arrSizeX = arrSizeX;
        this.arrSizeY = arrSizeY;
    }

    @Override
    public String getMessage() {
        return String.format("Размер массива %dх%d, необходим массив 4х4\n", arrSizeX, arrSizeY);
    }
}

class MyArrayDataException extends MyArrayException{

    int i, j;

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String getMessage() {
        return String.format("В ячейке %dx%d лежит символ или строка\n", i, j);
    }
}


