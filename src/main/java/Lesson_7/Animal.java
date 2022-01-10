package Lesson_7;
        /*
        1. Расширить задачу про котов и тарелки с едой.
        2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
        (например, в миске 10 еды, а кот пытается покушать 15-20).
        3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
        Если коту удалось покушать (хватило еды), сытость = true.
        4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
        то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
        5. Создать массив котов и тарелку с едой,
        попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
        6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
         */

public abstract class Animal {

    protected String name;
    //static int id = 0;

    void run(int len){
        System.out.printf("%s пробежал %d метров\n", name, len);
    }

    /*void countAnimal (){
        id += 1;
        System.out.printf("\n\n\nЖивотное номер %d\n", id);
    }*/
}

class Cat extends Animal{

    static int catId = 0;

    boolean fullness = false;

    Cat(String name){
        this.name = name;
        //super.countAnimal();
        catId += 1;
        System.out.printf("Мяу! Меня зовут %s\n", name);
    }

    @Override
    void run(int len) {
        if (len <= 200){
            super.run(len);
        }
    }

    /**
     * Метод, с помощью которого кот кушает
     * @param bowl тарелка, из которой кот будет кушать
     * @param necessary количество корма, необходимого коту
     */
    void eating (Bowl bowl, int necessary){
        if (bowl.amount >= necessary){
            bowl.amount -= necessary;
            fullness = true;
            System.out.printf("\n%s наелся! (В миске %d грамм корма)", name, bowl.amount);
        }
    }

    String getStatus(){
        if (fullness){
            return "";
        } else return name + " хочет кушать :(\n";
    }
}

class Bowl{

    int amount;
    static int bowlId = 0;

    Bowl (int amount){
        bowlId++;
        if (amount >= 0){
            this.amount = amount;
            System.out.printf("\nВ миске №%d %d грамм корма\n\n", bowlId, amount);
        } else System.out.printf("Хозяин, миске №%d не может быть так мало корма...", bowlId);
    }

    Bowl (){
        bowlId++;
        this.amount = 100;
        System.out.printf("В миске №%d %d грамм корма", bowlId, amount);
    }

    void addFood(int food){
        amount += food;
        System.out.printf("\n\nВы добавили корма! В миске №%d %d грамм корма", bowlId, amount);
    }
}