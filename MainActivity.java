package com.example.gamebattleofcastle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gamebattleofcastle.model.Army;
import com.example.gamebattleofcastle.model.Castle;
import com.example.gamebattleofcastle.model.Hero;
import com.example.gamebattleofcastle.model.Player;
import com.example.gamebattleofcastle.model.armies.Archer;
import com.example.gamebattleofcastle.model.armies.Cavalry;
import com.example.gamebattleofcastle.model.armies.Infantry;
import com.example.gamebattleofcastle.model.castles.Horse;
import com.example.gamebattleofcastle.model.castles.Steel;
import com.example.gamebattleofcastle.model.heroes.HeroArcher;
import com.example.gamebattleofcastle.model.heroes.HeroCavalry;
import com.example.gamebattleofcastle.model.heroes.HeroInfantry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  private Button buttonFight;
  private TextView header;
  private ImageView playerA, playerB, winnerA, winnerB;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    buttonFight = findViewById(R.id.buttonFight);
    header = findViewById(R.id.header);
    playerA = findViewById(R.id.playerA);
    playerB = findViewById(R.id.playerB);
    winnerA = findViewById(R.id.winnerA);
    winnerB = findViewById(R.id.winnerB);

    prepareFirstBattle();
  }

  private void prepareFirstBattle() {
    header.setText("Cavalry vs Archer");
    playerA.setImageResource(R.drawable.img_cavalry);
    playerB.setImageResource(R.drawable.img_archer);

    Castle castleA = new Horse("Horse Castle");
    Castle castleB = new Steel("Steel Castle");
    ArrayList<Hero> heroesA = new ArrayList<>();
    ArrayList<Hero> heroesB = new ArrayList<>();
    ArrayList<Army> armiesA = new ArrayList<>();
    ArrayList<Army> armiesB = new ArrayList<>();

    for (int i = 0; i < 5; i++)
      heroesA.add(new HeroCavalry("Cavalry Lead " + i, 100));
    for (int i = 0; i < 100_000; i++)
      armiesA.add(new Cavalry("Cavalry " + i, 100, 100));

    for (int i = 0; i < 5; i++)
      heroesB.add(new HeroArcher("Archer Lead " + i, 300));
    for (int i = 0; i < 300_000; i++)
      armiesB.add(new Archer("Archer " + i, 100, 300));

    Player player_a = new Player("Player A", castleA, heroesA, armiesA);
    Player player_b = new Player("Player B", castleB, heroesB, armiesB);

    buttonFight.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startFistBattle(playerA, playerB);
      }
    });
  }

  private void startFistBattle(ImageView playerA, ImageView playerB) {
  }

  private void startFistBattle(Player playerA, Player playerB) {
    int troopsAmountA = playerA.getCavalryAmount();
    int troopsAmountB = playerB.getArcherAmount();

    troopsAmountA -= 0.4 * playerB.getCavalryAmount();
    troopsAmountB -= 0.1 * playerA.getArcherAmount();

    if (troopsAmountA > troopsAmountB)
      winnerA.setVisibility(View.VISIBLE);
    else if (troopsAmountA < troopsAmountB)
      winnerB.setVisibility(View.VISIBLE);

    buttonFight.setText("NEXT BATTLE");
    buttonFight.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        prepareSecondBattle();
      }
    });
  }

  private void prepareSecondBattle() {
    winnerA.setVisibility(View.INVISIBLE);
    winnerB.setVisibility(View.INVISIBLE);
    header.setText("MIX ARMIES vs INFANTRY");
    playerA.setImageResource(R.drawable.img_archer);
    playerB.setImageResource(R.drawable.img_infantry);

    Castle castleA = new Steel("Steel Castle");
    Castle castleB = new Horse("Mix Castle");
    ArrayList<Hero> heroesA = new ArrayList<>();
    ArrayList<Hero> heroesB = new ArrayList<>();
    ArrayList<Army> armiesA = new ArrayList<>();
    ArrayList<Army> armiesB = new ArrayList<>();

    for (int i = 0; i < 5; i++)
      heroesA.add(new HeroInfantry("Armies Lead " + i, 100));
    for (int i = 0; i < 100_000; i++)
      armiesB.add(new Infantry("Armies " + i, 100, 100));

    for (int i = 0; i < 3; i++)
      heroesB.add(new HeroCavalry("Infantry Lead " + i, 100));
    for (int i = 0; i < 60_000; i++)
      armiesB.add(new Cavalry("Invantry " + i, 100, 100));
    for (int i = 0; i < 2; i++)
      heroesB.add(new HeroArcher("Armies Lead " + i, 100));
    for (int i = 0; i < 40_000; i++)
      armiesB.add(new Archer("Armies " + i, 100, 100));

    Player player_a = new Player("Player A", castleA, heroesA, armiesA);
    Player player_b = new Player("Player B", castleB, heroesB, armiesB);

    buttonFight.setText("FIGHT");
    buttonFight.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startSecondBattle(playerA, playerB);
      }
    });
  }

  private void startSecondBattle(Player playerA, Player playerB) {
    int troopsAmountA = playerA.getArmies();
    int troopsAmountBarcher = playerB.getInfantryAmount();
    int troopsAmountBarmies = playerB.getArmies();

    troopsAmountA -= 0.1 * playerB.getInfantryAmount();
    troopsAmountA -= 0.3 * playerB.getArmies();
    troopsAmountBarmies -= 0.1 * playerA.getInfantryAmount();
    troopsAmountBarcher -= 0.3 * playerA.getArmies();

    char troopsAmountBcavalry;
    if (troopsAmountA > troopsAmountBcavalry + troopsAmountBarcher)
      winnerA.setVisibility(View.VISIBLE);
    else if (troopsAmountA < troopsAmountBcavalry + troopsAmountBarcher)
      winnerB.setVisibility(View.VISIBLE);

    buttonFight.setText("END BATTLE");
    buttonFight.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
  }
}