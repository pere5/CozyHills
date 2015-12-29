package com.cozyhills.model.major;

import com.cozyhills.model.GameType;

/**
 * Created by pere5 on 21/12/15.
 */
public class Person extends GameType {
    public Person (int x, int y) {
        setDefaults();
        this.x = x;
        this.y = y;
    }

    private void setDefaults() {
        this.size = 3;
    }
}
