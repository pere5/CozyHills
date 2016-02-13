package com.cozyhills.things.buildings;

import com.cozyhills.Const;
import com.cozyhills.cozy.StateHolder;
import com.cozyhills.things.Person;
import com.cozyhills.things.items.Item;
import com.cozyhills.things.items.Stone;
import com.cozyhills.things.items.Wood;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pere5 on 28/01/16.
 */
public class BasicHut extends Home {

    private static final int ROOMS = 1;
    private static final int STATUS = 1;
    private static final Color CONSTRUCTING_COLOR = Color.decode("#1BFF55");
    private static final Color FINISHED_COLOR = Color.decode("#DEB887");
    private static final Map<Class<? extends Item>, Integer> BUILD_COST = new HashMap<>();

    static {
        BUILD_COST.put(Stone.class, 1);
        BUILD_COST.put(Wood.class, 2);
    }

    public BasicHut() {
        super(ROOMS, STATUS);
        this.color = FINISHED_COLOR;
        this.finished = true;
        setDefaults();
    }

    public BasicHut(Person me, double[] position) {
        super(ROOMS, STATUS, BUILD_COST);
        this.xy = position;
        this.color = CONSTRUCTING_COLOR;
        this.finished = false;
        setDefaults();
        moveIn(me);
        StateHolder.addVisibleEntity(this);
    }

    private void setDefaults() {
        this.size = 10;
        this.SHAPE = Const.SHAPES.CIRCLE;
    }

    protected Color getConstructingColor() {
        return CONSTRUCTING_COLOR;
    }

    protected Color getFinishedColor() {
        return FINISHED_COLOR;
    }

    public static Map<Class<? extends Item>, Integer> buildCost() {
        return BUILD_COST;
    }
}
