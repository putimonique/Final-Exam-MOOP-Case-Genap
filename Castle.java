package com.example.gamebattleofcastle.model;

public class Castle {
    private String name;

    public Castle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        String format = "%-25s %5s %s\n";
        System.out.format(format, "Castle Name", " :  ", this.name);
    }
}
