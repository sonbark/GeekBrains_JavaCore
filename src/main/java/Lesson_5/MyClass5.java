package Lesson_5;

public class MyClass5 {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Банзаракцаева Софья Евгеньевна", "Android Developer",
                "sofia_email@mail.com", "89998887766", 150000, 22);
        employees[1] = new Employee("Рвачев Никита Дмитриевич", "Tester",
                "kiki_email@mail.com", "89998887755", 200000, 25);
        employees[2] = new Employee("Егорова Диана Юрьевна", "Designer",
                "fitd_email@mail.com", "89008887755", 120000, 27);
        employees[3] = new Employee("Давыдов Максим Станиславович", "Team Lead",
                "teamlead@mail.com", "89000000007", 220000, 41);
        employees[4] = new Employee("Алхимов Марк Никитич", "Analyst",
                "alkhim@mail.com", "89995053246", 80000, 40);

        for (Employee employee : employees) {
            if (employee.age > 40) employee.printInfo();
        }
    }
}
