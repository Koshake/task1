package lesson6.animals;

public class Animal {
    String name;
    String color;
    int age;
    int maxRunDistance;
    int maxSwimDistance;

    public Animal() {
    }

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Animal(String name, String color, int age, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
    }

    public void info() {
        System.out.println(name + " " + color + " " + age);
    }

    public void swim(int distance) {
        if(distance > maxSwimDistance)
            System.out.println(name + " can't swim " + distance);
        else
            System.out.println(name + " swim " + distance);
    }

    public void run(int distance) {
        if(distance > maxRunDistance)
            System.out.println(name + " can't run " + distance);
        else
            System.out.println(name + " run " + distance);
    }

}
