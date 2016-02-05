package com.cozyhills.things.items;

import com.cozyhills.things.VisibleEntity;
import com.cozyhills.things.resources.Resource;
import com.cozyhills.things.resources.Rock;

/**
 * Created by pere5 on 28/01/16.
 */
public class Stone extends Item {
    @Override
    public Class<? extends Resource> getCorrespondingResource() {
        return Rock.class;
    }
}
