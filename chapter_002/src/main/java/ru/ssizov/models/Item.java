package ru.ssizov.models;


public class Item {

    private String name;

    private String description;

    private long create;

    private String id;


    public void setId(String id) {
        this.id = id;
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return this.create;
    }

    public String getId() {
        return this.id;
    }
}