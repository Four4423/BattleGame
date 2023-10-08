package com.example.testovoe2;

import android.content.Context;

public class Monster extends Creature {

    public Monster(Context context, String name, int attack, int defense, int health, int minDamage, int maxDamage) {
        super(context, name, attack, defense, health, minDamage, maxDamage, new MonsterBattleLog(context));
    }
}