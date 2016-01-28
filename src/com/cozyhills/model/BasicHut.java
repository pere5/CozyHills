package com.cozyhills.model;

import com.cozyhills.items.Stone;
import com.cozyhills.items.Wood;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pere5 on 28/01/16.
 */
public class BasicHut extends Home {
    private static Map<Class<?>, Integer> buildCost = new HashMap<>();
    static {
        buildCost.put(Stone.class, 1);
        buildCost.put(Wood.class, 1);
    }

    public static Map<Class<?>, Integer> buildCost() {
        return buildCost;
    }
}
