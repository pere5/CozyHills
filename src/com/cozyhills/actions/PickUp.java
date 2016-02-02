package com.cozyhills.actions;

import com.cozyhills.things.Person;
import com.cozyhills.things.VisibleEntity;

/**
 * Created by periks15 on 2016-02-02.
 */
public class PickUp implements Action {
    public PickUp(VisibleEntity resource) {
    }

    @Override
    public boolean doIt(Person me) {
        return false;
    }
}
