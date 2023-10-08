package com.example.testovoe2;

import android.content.Context;
import android.widget.Toast;

public class PlayerBattleLog extends ToastBattleLog {

    public PlayerBattleLog(Context context) {
        super(context);
    }

    @Override
    public void failedlHitLog() {
        Toast.makeText(context, "Вы промахнулись.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void logDamage(int damage) {
        Toast.makeText(context, "Вы успешно атаковали монстра и нанесли " + damage + " урона", Toast.LENGTH_SHORT).show();
    }
}
