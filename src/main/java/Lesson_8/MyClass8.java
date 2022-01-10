package Lesson_8;

public class MyClass8 {
    public static void main(String[] args) {
        Object[] participants = new Object[4];
        participants[0] = new Human("Mike");
        participants[1] = new Cat("Barsik");
        participants[2] = new Robot("M-034");
        participants[3] = new Human("Jane");

        Object[] barriers = {new Wall(1), new Wall(2), new Treadmill(100), new Treadmill(500)};

        for (int i = 0, j = 0; i<participants.length; i++, j++){
            //participants[i].run(barriers[j]);
        }
    }
}
