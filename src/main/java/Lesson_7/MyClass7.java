package Lesson_7;

public class MyClass7 {
    public static void main(String[] args) {
        /*
        1. Расширить задачу про котов и тарелки с едой.
        2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
        3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
        4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
        5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
        и потом вывести информацию о сытости котов в консоль.
        6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
         */

        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Котенок Гав");
        cats[1] = new Cat("Матроскин");
        cats[2] = new Cat("Барсик");
        cats[3] = new Cat("Кики");
        cats[4] = new Cat("Пушок");
        System.out.println("=============================================");

        Bowl bowl = new Bowl(400);

        for (Cat cat : cats){
            cat.eating(bowl, 100);
        }

        System.out.println();
        for (Cat cat : cats){
            System.out.print(cat.getStatus());
        }

        bowl.addFood(100);
        System.out.println();
        for (Cat cat : cats){
            if (!cat.fullness) cat.eating(bowl, 100);
        }
    }
}
