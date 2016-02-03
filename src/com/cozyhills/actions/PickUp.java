package com.cozyhills.actions;

import com.cozyhills.things.Person;
import com.cozyhills.things.VisibleEntity;
import com.cozyhills.things.items.Item;

/**
 * Created by periks15 on 2016-02-02.
 */
public class PickUp implements Action {
    public PickUp(Item resource) {
    }

    @Override
    public boolean doIt(Person me) {
        return false;
    }
}
