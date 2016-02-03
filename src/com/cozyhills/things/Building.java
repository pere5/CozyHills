package com.cozyhills.things;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pere5 on 02/02/16.
 */
public abstract class Building extends VisibleEntity {
    protected static Map<Class<?>, Integer> buildCost = new HashMap<>();
    private final int STATUS;

    public Building (int STATUS) {
        super();
        this.STATUS = STATUS;
    }

    public int getStatus() {
        return STATUS;
    }
}
