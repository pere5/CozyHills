package com.cozyhills.things.buildings;

import com.cozyhills.Const;
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
    private static final Color CONSTRUCTING_COLOR = Color.decode("#DE8D87");
    private static final Color FINISHED_COLOR = Color.decode("#DEB887");
    private static final Map<Class, Integer> BUILD_COST = new HashMap<>();

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

    public BasicHut(double[] position) {
        super(ROOMS, STATUS, BUILD_COST, position);
        this.color = CONSTRUCTING_COLOR;
        this.finished = false;
        setDefaults();
    }

    private void setDefaults() {
        this.size = 10;
        this.SHAPE = Const.SHAPES.CIRCLE;
    }

    public static Map<Class, Integer> buildCost() {
        return BUILD_COST;
    }
}
