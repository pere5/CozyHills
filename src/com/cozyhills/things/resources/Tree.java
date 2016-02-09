package com.cozyhills.things.resources;

import com.cozyhills.cozy.Util;
import com.cozyhills.things.items.Wood;

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

    private void setDefaults() {
        this.numberOfItems = 4;
        this.size = 4;
        this.color = Color.GREEN;
    }

    @Override
    public int getTurnsToGather() {
        return 10;
    }

    @Override
    protected Wood getItemType() {
        return new Wood();
    }
}
