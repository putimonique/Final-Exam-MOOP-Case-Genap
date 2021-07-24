package com.example.gamebattleofcastle.model.heroes;

import com.example.gamebattleofcastle.model.Hero;

public class HeroInfantry extends Hero {
  public HeroInfantry(String name, int level) {
    super(name, level);
  }

  @Override
  public void print() {
    String format = "%-25s %5s %s\n";
    System.out.format(format, "Type", " :  ", this.getClass().getSimpleName());
    super.print();
  }
}
