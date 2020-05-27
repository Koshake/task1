package lesson5;

public class Person {

    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void info() {
        System.out.printf("Name: %s\nPosition: %s\nEmail: %s\nPhone: %s\nSalary: %d\nAge: %d\n\n",
                name, position, email, phone, salary, age);
    }
}
