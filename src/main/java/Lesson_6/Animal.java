package Lesson_6;
        /*
        1. Создать классы Собака и Кот с наследованием от класса Животное.
        2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
            Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
        3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
        4. * Добавить подсчет созданных котов, собак и животных.
         */

public abstract class Animal {

    protected String name;
    static int id = 0;

    void run(int len){
        System.out.printf("%s пробежал %d метров\n", name, len);
    }

    void countAnimal (){
        id += 1;
        System.out.printf("\nЖивотное номер %d\n", id);
    }
}

class Cat extends Animal{

    static int catId = 0;

    Cat(String name){
        this.name = name;
        super.countAnimal();
        catId += 1;
        System.out.printf("Кот номер %d\n", catId);
    }

    @Override
    void run(int len) {
        if (len <= 200){
            super.run(len);
        }
    }
}

class Dog extends Animal{

    static int dogId = 0;

    Dog(String name){
        this.name = name;
        super.countAnimal();
        dogId += 1;
        System.out.printf("Собака номер %d\n", dogId);
    }

    @Override
    void run(int len) {
        if (len <= 500){
            super.run(len);
        }
    }

    void swim(int len) {
        if (len <= 10) {
            System.out.printf("%s проплыл %d метров\n", name, len);
        } /*
        как вариант
        else {
            System.out.printf("%s может проплыть максимум 10 метров!\n\n", name);
        }*/
    }
}