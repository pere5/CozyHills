package com.cozyhills.things.buildings;

import com.cozyhills.things.VisibleEntity;
import com.cozyhills.things.items.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pere5 on 02/02/16.
 */
public abstract class Building extends VisibleEntity {

    private final Map<Class, Integer> constructionMaterials;
    private final int STATUS;

    protected boolean finished;

    public Building(final int STATUS, final Map<Class, Integer> BUILD_COST, double[] position) {
        super(position);
        constructionMaterials = clone(BUILD_COST);
        this.STATUS = STATUS;
    }

    public Building(final int STATUS) {
        super();
        constructionMaterials = null;
        this.STATUS = STATUS;
    }

    private Map<Class, Integer> clone(Map<Class, Integer> BUILD_COST) {
        Map<Class, Integer> clone = new HashMap<>();
        BUILD_COST.forEach(clone::put);
        return clone;
    }

    public int getStatus() {
        return STATUS;
    }

    public boolean buildWith(Item item) {
        constructionMaterials.blahaBlaha!
        return false;
    }
}
