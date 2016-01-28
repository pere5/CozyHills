package com.cozyhills.model;

import com.cozyhills.cozy.Util;

import java.awt.*;

/**
 * Created by pere5 on 02/01/16.
 */
public class Tree extends VisibleEntity {
    public Tree () {
        setDefaults();
        this.x = Util.generateWidth();
        this.y = Util.generateHeight();
    }

    public Tree (int x, int y) {
        setDefaults();
        this.x = x;
        this.y = y;
    }

    private void setDefaults() {
        this.size = 4;
        this.color = Color.GREEN;
    }
}
