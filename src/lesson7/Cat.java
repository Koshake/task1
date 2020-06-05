package lesson7;

public class Cat {

    private String name;
    private int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = false;
    }

    public String getName() {
        return name;
    }

    public void info() {
        System.out.println(name + " is full: "+ isFull);
    }

    public void eat(Plate plate) {
        System.out.println(name + " eat...");
        if (appetite <= plate.getFood()) {
            plate.decreaseFood(appetite);
            isFull = true;
        }
    }
}
