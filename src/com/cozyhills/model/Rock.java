package com.cozyhills.model;

import com.cozyhills.cozy.Util;

import java.awt.*;

/**
 * Created by pere5 on 02/01/16.
 */
public class Rock extends VisibleEntity {
    public Rock () {
        setDefaults();
        this.x = Util.generateWidth();
        this.y = Util.generateHeight();
    }

    public Rock (int x, int y) {
        setDefaults();
        this.x = x;
        this.y = y;
    }

    private void setDefaults() {
        this.size = 10;
        this.color = Color.GRAY;
    }
}
