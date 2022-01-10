package Lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Class4 {

    static final char DOT_HUMAN = 'ꓫ';
    static final char DOT_AI = 'O';
    static final char DOT_EMPTY = '༚';
    static final int fieldSizeX = 5;
    static final int fieldSizeY = 5;
    static char[][] field;
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static final int WIN_COUNT = 4;
    static char winner = ' ';

    public static void main(String[] args) {
        System.out.println("Доброе пожаловать в КРЕСТИКИ - НОЛИКИ\n");

        initializeField();
        drawField();
        playGame();
    }

    static void initializeField(){

        field = new char[fieldSizeY][fieldSizeX];

        for (int y = 0; y<fieldSizeY; y++){
            for (int x = 0; x<fieldSizeX; x++){
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    static void drawField(){

        for (int y = 0; y<fieldSizeY; y++){
            System.out.print(" —— ");
        }

        for (int y = 0; y<fieldSizeY; y++){
            System.out.println();
            System.out.print("| ");

            for (int x = 0; x<fieldSizeX; x++) {
                System.out.print(field[y][x] + " | ");
            }
            System.out.println();
            for (int x = 0; x<fieldSizeX; x++){
                System.out.print(" —— ");
            }
        }
    }

    static void playGame(){
        do {
            //ход человека
            yourTurn();
            drawField();
            if (checkWin()) break;
            if (isFinish()) break;
            //ход компьютера
            myTurn();
            drawField();
            if (checkWin()) break;
        } while (!isFinish());

        if(winner == ' ') {System.out.println("\n\nНичья! Спасибо за игру:)\n\n");}
        else System.out.printf("\n\nПобеда %s\n\n", winner);
    }

    static void yourTurn(){
        System.out.println("\n\nВаш ход!\nВведите координаты через пробел");

        int x, y;
        do{
            x = scanner.nextInt()-1;
            y = scanner.nextInt()-1;
            System.out.println(isValid(x, y));
        } while (!isValid(x, y).equals(""));
        field[y][x] = DOT_HUMAN;
    }

    /**
     * Метод проверяет корректность ввода координат
     * @param x координата х
     * @param y координата y
     * @return Сообщение - результат проверки
     */
    static String isValid(int x, int y){
        if (x<0 || x>=fieldSizeX || y<0 || y>=fieldSizeY){
            return "Введите корректные координаты хода";
        }
        if (field[y][x] != DOT_EMPTY){
            return "Данное поле уже занято, сделайте другой ход";
        }
        return "";
    }

    static void myTurn(){
        System.out.println("\n\nМой ход!");

        int[] coordinates = interfere();

        int y = coordinates[0];
        int x = coordinates[1];
        field[y][x] = DOT_AI;
    }

    /**
     * Метод для "перехватывания" победных ходов человека
     * Метод проверяет, есть ли у человека стратегия к выигрышу:
     * по вертикали, по горизонтали или по диагоналям
     * @return массив из координат для хода
     */
    static int[] interfere(){
        char gonnaWin;

        int[] coordinates = new int[2];

        for (int y = 0; y<fieldSizeY; y++){
            for (int x = 0; x<fieldSizeX; x++){
                if (field[y][x] == DOT_HUMAN) {
                    gonnaWin = will_X_Win(x, y, WIN_COUNT);
                    if (gonnaWin!=' '){
                        switch (gonnaWin){
                            case 'x':
                                if (field[y][x+WIN_COUNT-1] == DOT_EMPTY) {
                                    coordinates[0] = y;
                                    coordinates[1] = x+WIN_COUNT-1;
                                    return coordinates;
                                }
                                break;
                            case 'y':
                                if (field[y+WIN_COUNT-1][x] == DOT_EMPTY) {
                                    coordinates[0] = y+WIN_COUNT-1;
                                    coordinates[1] = x;
                                    return coordinates;
                                }
                                break;
                            case '1':
                                if (field[y+WIN_COUNT-1][x+WIN_COUNT-1] == DOT_EMPTY) {
                                    coordinates[0] = y+WIN_COUNT-1;
                                    coordinates[1] = x+WIN_COUNT-1;
                                    return coordinates;}
                                break;
                            case '2':
                                if (field[y+WIN_COUNT-1][x-WIN_COUNT+1] == DOT_EMPTY) {
                                    coordinates[0] = y+WIN_COUNT-1;
                                    coordinates[1] = x-WIN_COUNT+1;
                                    return coordinates;}
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        //если у человека нет стратегии к выигрышу, то выбираем рандомные координаты хода
        do{
            coordinates[0] = random.nextInt(fieldSizeY);
            coordinates[1] = random.nextInt(fieldSizeX);
        } while (field[coordinates[0]][coordinates[1]] != DOT_EMPTY);

        return coordinates;
    }

    /**
     * Метод проверяет, закончена ли игра
     * @return булевое значение: закончена/не закончена
     */
    static boolean isFinish(){
        int count = 0;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] != DOT_EMPTY) {
                    count += 1;
                }
            }
        }
        return count == fieldSizeX * fieldSizeY;
    }

    /**
     * Метод проверяет на "победу" каждую клеточку поля
     * @return булевое значение: победа/не  победа
     */
    static boolean checkWin() {
        for (int y = 0; y<fieldSizeY; y++){
            for (int x = 0; x<fieldSizeX; x++){
                if (field[y][x] != DOT_EMPTY) {
                    if (isWin(field[y][x], x, y, WIN_COUNT)){
                        winner = field[y][x];
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Метод проверяет, произошла ли победа
     * @param c фишка игрока, которого проверяем на "победителя"
     * @param x координата х
     * @param y координата у
     * @param winCount количество фишек, необходимых для победы
     * @return булевое значение: победа/не победа
     */
    static boolean isWin (char c, int x, int y, int winCount){
        int countX = 0;
        int countY = 0;
        int countDi1 = 0;
        int countDi2 = 0;
        winCount-=1;

        //по горизонтали
        if (x<=fieldSizeX-1-winCount){
            for (int i = 1; i<=winCount; i++){
                if (field[y][x+i] == c)
                    countX += 1;
            }
        }

        //по вертикали
        if (y<=fieldSizeY-1-winCount){
            for (int i = 1; i<=winCount; i++){
                if (field[y+i][x] == c)
                    countY += 1;
            }
        }

        //по главной диагонали
        if (y<=fieldSizeY-1-winCount && x<=fieldSizeX-1-winCount){
            for (int i = 1; i<=winCount; i++){
                if (field[y+i][x+i] == c)
                    countDi1 += 1;
            }
        }

        //по побочной диагонали
        if (y<=fieldSizeY-1-winCount && x>=winCount){
            for (int i = 1; i<=winCount; i++){
                if (field[y+i][x-i] == c)
                    countDi2 += 1;
            }
        }

        return countX == winCount || countY == winCount || countDi1 == winCount || countDi2 == winCount;
    }

    /**
     * Метод проверяет, где собирается выиграть человек
     * Логика такая: если на поле в ряд собирается больше двух фишек, то это может привести к победе противника
     * @param x координата х
     * @param y координата у
     * @param winCount количество фишек, необходимое для победы
     * @return символ стратегии победы: по вертикали, по горизонтали или по диагоналям
     */
    static char will_X_Win (int x, int y, int winCount){
        int countX = 0;
        int countY = 0;
        int countDi1 = 0;
        int countDi2 = 0;
        winCount-=1;

        if (x<=fieldSizeX-1-winCount){
            for (int i = 1; i<=winCount; i++){
                if (field[y][x+i] == DOT_HUMAN)
                    countX += 1;
            }
        }

        if (y<=fieldSizeY-1-winCount){
            for (int i = 1; i<=winCount; i++){
                if (field[y+i][x] == DOT_HUMAN)
                    countY += 1;
            }
        }

        if (y<=fieldSizeY-1-winCount && x<=fieldSizeX-1-winCount){
            for (int i = 1; i<=winCount; i++){
                if (field[y+i][x+i] == DOT_HUMAN)
                    countDi1 += 1;
            }
        }

        if (y<=fieldSizeY-1-winCount && x>=winCount){
            for (int i = 1; i<=winCount; i++){
                if (field[y+i][x-i] == DOT_HUMAN)
                    countDi2 += 1;
            }
        }

        if (countX >= 2) return 'x';
        if (countY >= 2) return 'y';
        if (countDi1 >= 2) return '1';
        if (countDi2 >= 2) return '2';

        return ' ';
    }
}
