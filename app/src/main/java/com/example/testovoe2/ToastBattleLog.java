package com.example.testovoe2;

import android.content.Context;

public abstract class ToastBattleLog implements IBattleLog {
    protected Context context;
    public ToastBattleLog(Context context) {
        this.context = context;
    }
}
