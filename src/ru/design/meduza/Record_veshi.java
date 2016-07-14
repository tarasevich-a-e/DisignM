package ru.design.meduza;

/**
 * Created by taras_000 on 13.06.2016.
 */
public class Record_veshi {
    private int id;
    private String name;
    private String type_v;
    private String type;
    private int cost;
    private String discribe;
    private String size;
    private String color;
    private int quantity;
    private int like;
    private String link;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType_v() {
        return type_v;
    }

    public String getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }

    public String getDiscribe() {
        return discribe;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getLike() {
        return like;
    }

    public String getLink() {
        return link;
    }

    public Record_veshi(int id, String name, String type_v, String type, int cost, String discribe, String size, String color, int quantity, int like, String link) {
        this.id = id;
        this.name = name;
        this.type_v = type_v;
        this.type = type;
        this.cost = cost;
        this.discribe = discribe;
        this.size = size;
        this.color = color;
        this.quantity = quantity;
        this.like = like;
        this.link = link;
    }
}
