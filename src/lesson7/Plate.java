package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food > 0 ?  food : 0;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        food = food - amount > 0 ? food - amount : 0;
    }

    public void increaseFood(int amount) {
        food += amount;
    }

    public void info(){
        System.out.println("Plate: "+ food);
    }
}
