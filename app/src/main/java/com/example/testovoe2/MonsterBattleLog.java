package com.example.testovoe2;

import android.content.Context;
import android.widget.Toast;


public class MonsterBattleLog extends ToastBattleLog {

    public MonsterBattleLog(Context context) {
        super(context);
    }

    @Override
    public void failedlHitLog() {
        Toast.makeText(context, "Монстр промахнулся.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void logDamage(int damage) {
        Toast.makeText(context, "Монстр успешно атаковал Вас и нанес " + damage + " урона", Toast.LENGTH_SHORT).show();
    }
}
