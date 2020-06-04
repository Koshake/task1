package lesson6.animals;

public class Dog extends Animal{

    final int MAX_RUN = 500;
    final int MAX_SWIM = 10;

    public Dog(String name, String color, int age) {
        super(name, color, age);
        maxRunDistance = MAX_RUN;
        maxSwimDistance = MAX_SWIM;
    }

    public Dog(String name, String color, int age, int maxRunDistance, int maxSwimDistance) {
        super(name, color, age, maxRunDistance, maxSwimDistance);
    }
}
