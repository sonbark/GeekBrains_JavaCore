package Lesson_5;

public class Employee {

    String fullName;
    String position;
    String email;
    String phoneNumber;
    int salary;
    int age;

    Employee(String fullName, String position, String email, String phoneNumber, int salary, int age){
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    void printInfo(){
        System.out.printf("%s\n%s\nКонтакты: %s, %s\nЗарплата: %d, возраст: %d\n\n",
                position, fullName, phoneNumber, email, salary, age);
    }
}
