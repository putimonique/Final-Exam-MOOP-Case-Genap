package com.example.gamebattleofcastle.model;

public class Hero {
  private String name;
  private int level;

  public Hero(String name, int level) {
    this.name = name;
    if (level < 1) {
      this.level = 1;
    } else if (level > 50) {
      this.level = 50;
    } else {
      this.level = level;
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    if (level < 1) {
      this.level = 1;
    } else if (level > 50) {
      this.level = 50;
    } else {
      this.level = level;
    }
  }

  public void print() {
    String format = "%-25s %5s %s\n";
    System.out.format(format, "Name", " :  ", this.name);
    System.out.format(format, "Level", " :  ", this.level);
    System.out.println("............................................");
  }
}
