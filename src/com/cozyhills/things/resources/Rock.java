package com.cozyhills.things.resources;

import com.cozyhills.cozy.Util;
import com.cozyhills.things.items.Item;
import com.cozyhills.things.items.Stone;
import com.cozyhills.things.items.Wood;

import java.awt.*;
import java.util.Optional;

/**
 * Created by pere5 on 02/01/16.
 */
public class Rock extends Resource {
    public Rock () {
        super();
        setDefaults();
        this.xy[0] = Util.generateWidth();
        this.xy[1] = Util.generateHeight();
    }

    private void setDefaults() {
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
