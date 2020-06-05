package lesson7;

import lesson6.animals.Animal;

public class Main {

    public static void main(String[] args) {

        Cat cat1;
        Cat[] cats = {
            new Cat("Kitty", 50),
            new Cat("Tiger", 30),
            new Cat("Tom", 100),
        };

        Plate plate = new Plate(100);

        for (Cat cat: cats) {
            cat.eat(plate);
            cat.info();
        }

        plate.info();
        plate.increaseFood(100);
        plate.info();
    }
}
