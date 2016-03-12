package com.cozyhills.things.resources;

import com.cozyhills.things.items.Stone;

import java.awt.*;

/**
 * Created by pere5 on 02/01/16.
 */
public class Rock extends Resource {

    public Rock () {
        super();
        setDefaults();
    }

    private void setDefaults() {
        this.numberOfItems = 4;
        this.size = 10;
        this.color = Color.GRAY;
    }

    @Override
    public int getTurnsToGather() {
        return 15;
    }

    @Override
    protected Stone getItemType() {
        return new Stone();
    }
}
