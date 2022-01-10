package Lesson_8;

interface Runnable{

    String getName();
    void run(Treadmill treadmill);
}

interface Bouncing{
    String getName();
    void run(Wall wall);
}

class Human implements Runnable, Bouncing{
    String name;

    public String getName() {
        return name;
    }

    Human(String name){
        this.name = name;
        System.out.printf("Привет! Меня зовут %s\n", name);
    }

    public void run(Treadmill treadmill){
        System.out.printf("%s пробежал %d метров\n", name, treadmill.len);
    }

    public void run(Wall wall){
        System.out.printf("%s перепрыгнул %d метров\n", name, wall.high);
    }
}

class Cat implements Runnable, Bouncing{

    String name;

    Cat(String name){
        this.name = name;
        System.out.printf("Мяу! Меня зовут %s\n", name);
    }

    public String getName() {
        return name;
    }

    public void run(Treadmill treadmill){
        System.out.printf("%s пробежал %d метров\n", name, treadmill.len);
    }

    public void run(Wall wall){
        System.out.printf("%s перепрыгнул %d метров\n", name, wall.high);
    }

}

class Robot implements Runnable, Bouncing{
    String name;

    Robot(String name){
        this.name = name;
        System.out.printf("Я робот! Меня зовут %s\n", name);
    }

    public String getName() {
        return name;
    }

    public void run(Treadmill treadmill){
        System.out.printf("%s пробежал %d метров\n", name, treadmill.len);
    }

    public void run(Wall wall){
        System.out.printf("%s перепрыгнул %d метров\n", name, wall.high);
    }
}