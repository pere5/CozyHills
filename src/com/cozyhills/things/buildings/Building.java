package com.cozyhills.things.buildings;

import com.cozyhills.things.VisibleEntity;
import com.cozyhills.things.items.Item;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pere5 on 02/02/16.
 */
public abstract class Building extends VisibleEntity {

    private final Map<Class<? extends Item>, Integer> constructionMaterials;
    private final int status;

    protected boolean finished;

    public Building(int status, Map<Class<? extends Item>, Integer> buildCost) {
        super();
        this.constructionMaterials = clone(buildCost);
        this.status = status;
    }

    public Building(int status) {
        super();
        this.constructionMaterials = new HashMap<>();
        this.status = status;
    }

    private Map<Class<? extends Item>, Integer> clone(Map<Class<? extends Item>, Integer> buildCost) {
        Map<Class<? extends Item>, Integer> clone = new HashMap<>();
        buildCost.forEach(clone::put);
        return clone;
    }

    public int getStatus() {
        return status;
    }

    protected abstract Color getFinishedColor();
    protected abstract Color getConstructingColor();

    public void buildWith(Item item) {
        Integer buildCost = constructionMaterials.get(item.getClass());
        buildCost--;
        if (buildCost == 0) {
            finished = true;
            color = getFinishedColor();
            constructionMaterials.clear();
        } else {
            constructionMaterials.put(item.getClass(), buildCost);
        }
    }

    public boolean completed() {
        return finished;
    }

    public Map<Class<? extends Item>, Integer> remainingBuildCost() {
        return constructionMaterials;
    }
}
