package model;

public class Toy {
    int id;
    String name;
    int counter;
    int weight;

    public String info() {
        return "Ваша призовая игрушка: " +
                "id: " + this.getId() +
                "; наименование: " + this.getName() +
                "; в наличии: " + this.getСounter() +
                "; вес: " + this.getWeight();
    }

    public Toy() {
    }

    public Toy(int id, String name, int counter, int weight) {
        this.id = id;
        this.name = name;
        this.counter = counter;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getСounter() {
        return counter;
    }

    public void setСounter(int counter) {
        this.counter = counter;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
