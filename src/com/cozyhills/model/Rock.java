package com.cozyhills.model;

import com.cozyhills.cozy.Util;

import java.awt.*;

/**
 * Created by pere5 on 02/01/16.
 */
public class Rock extends VisibleEntity {
    public Rock () {
        setDefaults();
        this.xy[0] = Util.generateWidth();
        this.xy[1] = Util.generateHeight();
    }

    public Rock (int x, int y) {
        setDefaults();
        this.xy[0] = x;
        this.xy[1] = y;
    }

    private void setDefaults() {
        this.size = 10;
        this.color = Color.GRAY;
    }
}
