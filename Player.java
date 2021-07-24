package com.example.gamebattleofcastle.model;

import com.example.gamebattleofcastle.model.armies.Archer;
import com.example.gamebattleofcastle.model.armies.Catapult;
import com.example.gamebattleofcastle.model.armies.Cavalry;
import com.example.gamebattleofcastle.model.armies.Infantry;
import com.example.gamebattleofcastle.model.heroes.HeroArcher;
import com.example.gamebattleofcastle.model.heroes.HeroCatapult;
import com.example.gamebattleofcastle.model.heroes.HeroCavalry;
import com.example.gamebattleofcastle.model.heroes.HeroInfantry;

import java.util.ArrayList;

public class Player {
  private String name;
  private Castle castle;
  private ArrayList<Hero> heroes;
  private ArrayList<Army> armies;
  private int archerAmount = 0;
  private int catapultAmount = 0;
  private int cavalryAmount = 0;
  private int infantryAmount = 0;

  public Player(String name, Castle castle, ArrayList<Hero> heroes, ArrayList<Army> armies) {
    this.name = name;
    this.castle = castle;
    this.heroes = heroes;
    this.armies = armies;

    setBoost();
  }

  public void setBoost() {
    double archerBoost = 0;
    double catapultBoost = 0;
    double cavalryBoost = 0;
    double infantryBoost = 0;

    for (Hero hero : this.heroes) {
      if (hero instanceof HeroArcher) archerBoost += 0.4;
      else if (hero instanceof HeroCatapult) catapultBoost += 0.4;
      else if (hero instanceof HeroCavalry) cavalryBoost += 0.4;
      else if (hero instanceof HeroInfantry) infantryBoost += 0.4;
    }

    for (Army army : this.armies) {
      if (army instanceof Archer) archerAmount++;
      else if (army instanceof Catapult) catapultAmount++;
      else if (army instanceof Cavalry) cavalryAmount++;
      else if (army instanceof Infantry) infantryAmount++;
    }

    this.archerAmount += (int) (archerBoost * archerAmount);
    this.catapultAmount += (int) (catapultBoost * catapultAmount);
    this.cavalryAmount += (int) (cavalryBoost * cavalryAmount);
    this.infantryAmount += (int) (infantryBoost * infantryAmount);
  }

  public int getArcherAmount() {
    return archerAmount;
  }

  public int getCatapultAmount() {
    return catapultAmount;
  }

  public int getCavalryAmount() {
    return cavalryAmount;
  }

  public int getInfantryAmount() {
    return infantryAmount;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Castle getCastle() {
    return castle;
  }

  public void setCastle(Castle castle) {
    this.castle = castle;
  }

  public ArrayList<Hero> getHeroes() {
    return heroes;
  }

  public void setHeroes(ArrayList<Hero> heroes) {
    this.heroes = heroes;
  }

  public ArrayList<Army> getArmies() {
    return armies;
  }

  public void setArmies(ArrayList<Army> armies) {
    this.armies = armies;
  }


  public void stats() {
    String format = "%-25s %5s %s\n";
    System.out.println("********************************************");

    System.out.format(format, "Player Name", " :  ", this.name);
    this.castle.print();
    System.out.format(format, "Castle Skin", " :  ", this.castle.getClass().getSimpleName());

    System.out.format(format, "Number of Heroes", " :  ", this.heroes.size());
    System.out.println("List of Heroes: ");
    System.out.println("............................................");
    for (Hero hero : this.heroes) {
      hero.print();
    }

    System.out.format(format, "Number of Armies", " :  ", this.armies.size());
    System.out.println("List of Armies: ");
    System.out.println("............................................");
    for (Army army : this.armies) {
      army.print();
    }

    System.out.println("********************************************");
  }
}
