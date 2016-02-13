package com.cozyhills.things.resources;

import com.cozyhills.things.items.Wood;

import java.awt.*;

/**
 * Created by pere5 on 02/01/16.
 */
public class Tree extends Resource {

    public Tree () {
        super();
        setDefaults();
    }

    private void setDefaults() {
        this.numberOfItems = 400;
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
