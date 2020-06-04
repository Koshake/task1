package lesson6.animals;

public class Cat extends Animal {

    final int MAX_RUN = 200;

    public Cat(String name, String color, int age) {
        super(name, color, age);
        maxRunDistance = MAX_RUN;
    }

    public Cat(String name, String color, int age, int maxRunDistance) {
        super(name, color, age, maxRunDistance, 0);
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " can't swim!");
    }
}
