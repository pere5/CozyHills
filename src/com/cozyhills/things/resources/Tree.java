package com.cozyhills.things.resources;

import com.cozyhills.cozy.Util;

import java.awt.*;

/**
 * Created by pere5 on 02/01/16.
 */
public class Tree extends Resource {
    public Tree () {
        super();
        setDefaults();
        this.xy[0] = Util.generateWidth();
        this.xy[1] = Util.generateHeight();
    }

    public Tree (int x, int y) {
        super();
        setDefaults();
        this.xy[0] = x;
        this.xy[1] = y;
    }

    private void setDefaults() {
        this.size = 4;
        this.color = Color.GREEN;
    }
}
