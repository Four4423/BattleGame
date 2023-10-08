package com.example.testovoe2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected Player player;
    private Monster monster;
    private TextView resultTextView;
    private static ImageView monsterImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView = findViewById(R.id.resultTextView);
        player = new Player(this, "Игрок", 10, 10, 80, 10, 15);
        monster = new Monster(this, "Монстр", 15, 6, 80, 5, 15);
        TextView monsterHealthTextView = findViewById(R.id.monsterHealthTextView);
        monsterHealthTextView.setText("Здоровье монстра: " + monster.getHealth());
        TextView playerHealthTextView = findViewById(R.id.playerHealthTextView);
        playerHealthTextView.setText("Здоровье игрока: " + player.getHealth());
        Button battleButton = findViewById(R.id.attackButton);
        battleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monsterImg = findViewById(R.id.monsterImageView);
                performBattle();
                if ((player.getHealth() == 0) && monster.isAlive()) {
                    monsterImg.setImageResource(R.drawable.monsterwin);
                    resultTextView.setText("Монстр победил!");
                } else if ((monster.getHealth() == 0) && player.isAlive()) {
                    monsterImg.setImageResource(R.drawable.monsterlose);
                    resultTextView.setText("Игрок победил!");
                } else {
                    monsterImg.setImageResource(R.drawable.monstertakedamage);
                }
            }
        });

        Button healButton = findViewById(R.id.healButton);
        healButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.heal();
                playerHealthTextView.setText("Здоровье игрока: " + player.getHealth());
            }
        });
    }

    private boolean performBattle() {
        boolean playerWon = false;
        if (player.isAlive() && monster.isAlive()) {
            player.attacks(monster);
            TextView monsterHealthTextView = findViewById(R.id.monsterHealthTextView);
            monsterHealthTextView.setText("Здоровье монстра: " + monster.getHealth());
            if (monster.isAlive()) {
                monster.attacks(player);
                TextView playerHealthTextView = findViewById(R.id.playerHealthTextView);
                playerHealthTextView.setText("Здоровье игрока: " + player.getHealth());
            }
            if (player.isAlive()) {
                playerWon = true;
            }
        }
        return playerWon;
    }
    }
