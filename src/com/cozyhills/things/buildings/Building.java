package com.cozyhills.things.buildings;

import com.cozyhills.cozy.Util;
import com.cozyhills.things.VisibleEntity;
import com.cozyhills.things.items.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pere5 on 02/02/16.
 */
public abstract class Building extends VisibleEntity {

    private final Map<Class, Integer> constructionMaterials;
    private final int status;

    protected boolean finished;

    public Building(int status, Map<Class, Integer> buildCost) {
        super();
        this.constructionMaterials = clone(buildCost);
        this.status = status;
    }

    public Building(int status) {
        super();
        this.constructionMaterials = null;
        this.status = status;
    }

    private Map<Class, Integer> clone(Map<Class, Integer> BUILD_COST) {
        Map<Class, Integer> clone = new HashMap<>();
        BUILD_COST.forEach(clone::put);
        return clone;
    }

    public int getStatus() {
        return status;
    }

    public boolean buildWith(Item item) {
        constructionMaterials.blahaBlaha!;
        if (klar) {
            finished = true;
        } else {
            finished = false;
        }
        return false;
    }

    public boolean underConstruction() {
        return finished;
    }

    public Map<Class, Integer> remainingBuildCost() {
        return constructionMaterials;
    }
}
