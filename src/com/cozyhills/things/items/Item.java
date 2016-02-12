package com.cozyhills.things.items;

import com.cozyhills.things.VisibleEntity;
import com.cozyhills.things.resources.Resource;

/**
 * Created by periks15 on 2016-02-02.
 */
public abstract class Item extends VisibleEntity {

    public Item () {
        super();
    }

    public abstract Class<Resource> getCorrespondingResourceType();
}
