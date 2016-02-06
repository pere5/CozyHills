package com.cozyhills.things.resources;

import com.cozyhills.things.VisibleEntity;
import com.cozyhills.things.items.Item;

/**
 * Created by pere5 on 03/02/16.
 */
public abstract class Resource extends VisibleEntity {

    protected int numberOfItems;

    public abstract int getTurnsToGather();

    protected abstract Item getItemType();

    public Item gathered() {
        numberOfItems--;
        if (numberOfItems < 0) {
            removeVisibleEntity(this);
        }
        return getItemType();
    }
}
