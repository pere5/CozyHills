package com.cozyhills.things;

import com.cozyhills.actions.Build;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pere5 on 02/02/16.
 */
public abstract class Building extends VisibleEntity {
    protected static Map<Class<?>, Integer> buildCost = new HashMap<>();

    public Building () {
        super();
    }
}
