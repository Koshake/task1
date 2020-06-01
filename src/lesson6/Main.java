package lesson6;

import lesson6.animals.*;

public class Main {

    public static void main(String[] args) {

        Animal[] animals = {
                new Cat("Barsik", "red", 2),
                new Dog("Tuzik", "white", 3, 200, 20),
                new Cat("Murzik", "gray", 5, 100),
                new Dog("Bobic", "black", 7),
                new Cat("Kitty", "black", 1),
        };

        for (Animal animal: animals) {
            animal.run(200);
            animal.swim(15);
        }

        // count Animals
        int animalCount = 0;
        int cats = 0;
        int dogs = 0;

        for (Animal animal: animals) {
            animalCount++;
            if (animal instanceof Cat) {
                cats++;
            }
            else if (animal instanceof  Dog) {
                dogs++;
            }
        }

        System.out.printf("%d animals, %d cats, %d dogs\n", animalCount, cats, dogs);
    }
}
