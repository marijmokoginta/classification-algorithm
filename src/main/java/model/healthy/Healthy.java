package model.healthy;

public class Healthy {

    private String name;
    private int age;
    private int weight;

    private boolean health;

    private int distance;

    public Healthy(){}

    public Healthy(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Healthy(String name, int age, int weight, boolean health) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isHealth() {
        return health;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Healthy{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", health=" + health +
                '}';
    }
}
