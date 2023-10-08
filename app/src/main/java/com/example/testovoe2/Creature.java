package com.example.testovoe2;
import android.content.Context;
import java.util.Random;

public class Creature implements ICreature {
    protected String name;
    protected int attack;
    protected int defense;
    protected int health;
    protected Context context;
    protected int maxDamage;
    protected int minDamage;
    private IBattleLog log;

    public Creature(Context context, String name, int attack, int defense, int health, int minDamage, int maxDamage, IBattleLog log){
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
        this.context = context;
        this.log = log;

        if (minDamage > maxDamage){
            throw new IllegalArgumentException("MinDamage cannot be more than MaxDamage.");
        }
    }

    @Override
    public int getMinDamage() {
        return minDamage;
    }

    @Override
    public int getMaxDamage() {
        return maxDamage;
    }

    @Override
    public void attacks(ICreature defender) {
        if (defender == null) {
            throw new IllegalArgumentException("Defender cannot be null.");
        }

        if (successfulAttack(defender)){
            int damageDealt = givenDamage();
            defender.takeDamage(damageDealt);
            log.logDamage(damageDealt);
        }
        else {
            log.failedlHitLog();
        }


    }
    @Override
    public void takeDamage(int damage) {
            if (damage < 0) {
                throw new IllegalArgumentException("Damage cannot be negative.");
            }
            health -= damage;
            if (health < 0) {
                health = 0;
            }
        }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public boolean successfulAttack(ICreature defender) {
        int attackModifier = this.getAttack() - defender.getDefense() + 1;
        int diceRolls = Math.max(attackModifier, 1);

        for (int i = 0; i < diceRolls; i++) {
            int diceResult = new Random().nextInt(6);
            if (diceResult >= 4) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int givenDamage() {
        int damage = 0;
            int minDamage = Math.min(this.getMinDamage(), this.getMaxDamage());
            int maxDamage = Math.max(this.getMinDamage(), this.getMaxDamage());
            damage = new Random().nextInt(maxDamage - minDamage + 1) + minDamage;
        return damage;
    }
}




