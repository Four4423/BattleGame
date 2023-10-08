package com.example.testovoe2;

public interface ICreature {
    public void attacks(ICreature defender);

    public void takeDamage(int damage);

    public boolean isAlive();

    public String getName();

    public int getDefense();

    public int getMinDamage();

    public int getMaxDamage();

    public int getHealth();

    public int getAttack();

    public int givenDamage();
}
