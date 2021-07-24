package com.example.gamebattleofcastle.model.armies;

import com.example.gamebattleofcastle.model.Army;

public class Cavalry extends Army {
  public Cavalry(String name, double skill, double attack) {
    super(name, skill, attack);
  }

  @Override
  public void print() {
    String format = "%-25s %5s %s\n";
    System.out.format(format, "Type", " :  ", this.getClass().getSimpleName());
    super.print();
  }
}
