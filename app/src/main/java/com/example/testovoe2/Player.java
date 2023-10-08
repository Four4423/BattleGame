package com.example.testovoe2;

import android.content.Context;
import android.widget.Toast;

public class Player extends Creature {
    private int maxHealth;
    private int healingCount = 0;

    public Player(Context context, String name, int attack, int defense, int health, int minDamage, int maxDamage) {
        super(context, name, attack, defense, health, minDamage, maxDamage, new PlayerBattleLog(context));
        this.maxHealth = health;

    }

    public void heal() {
        if (healingCount < 4) {
            int maxHealing = maxHealth / 3;
            health = health + maxHealing;
            if (health > maxHealth) {
                health = maxHealth;
            }
            healingCount++;
        } else {
            Toast.makeText(context, "Вы больше не можете лечиться.", Toast.LENGTH_SHORT).show();
        }
    }
}
