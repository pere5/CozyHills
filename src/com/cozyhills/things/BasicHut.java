package com.cozyhills.things;

import com.cozyhills.cozy.Util;
import com.cozyhills.things.items.Stone;
import com.cozyhills.things.items.Wood;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pere5 on 28/01/16.
 */
public class BasicHut extends Home {

    final static int ROOMS = 1;
    final private static int STATUS = 1;

    public BasicHut () {
        super(ROOMS, STATUS);
    }

    static {
        buildCost.put(Stone.class, 1);
        buildCost.put(Wood.class, 2);
    }

    public static Map<Class<?>, Integer> buildCost() {
        return buildCost;
    }
}
