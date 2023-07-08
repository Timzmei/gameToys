package model;

import java.util.Random;

public class Toy {
    private int id;
    private String name;
    private int count;
    private int percent;


    public Toy(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.percent = new Random().nextInt(1, 100);
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getPercent() {
        return percent;
    }

    public void changePercent(int percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name +
                ", count=" + count +
                ", percent=" + percent +
                '}';
    }
}
