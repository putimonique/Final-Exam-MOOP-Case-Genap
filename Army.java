package com.example.gamebattleofcastle.model;

public class Army {
    private String name;
    private double skill;
    private double attack;

    public Army(String name, double skill, double attack) {
        this.name = name;
        this.skill = skill;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSkill() {
        return skill;
    }

    public void setSkill(double skill) {
        this.skill = skill;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public void boostSkill() {
        this.skill += this.skill * 0.2;
    }

    public void boostAttack() {
        this.attack += this.attack * 0.4;
    }

    public void print() {
        String format = "%-25s %5s %s\n";
        System.out.format(format, "Army Name", " :  ", this.name);
        System.out.format(format, "Skill Point", " :  ", this.skill);
        System.out.format(format, "Attack Point", " :  ", this.attack);
        System.out.println("............................................");
    }
}
