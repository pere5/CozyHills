package com.cozyhills.actions;

import com.cozyhills.cozy.Util;
import com.cozyhills.things.Person;
import com.cozyhills.things.VisibleEntity;
import com.cozyhills.things.items.Item;

/**
 * Created by periks15 on 2016-02-02.
 */
public class PickUp extends Action {
    private final Item resource;

    public PickUp(Item resource) {
        this.resource = resource;
        Util.printNotImplemented("Pick up!");
    }

    @Override
    public boolean doIt(Person me) {
        if (closeEnough(me.xy, resource.xy)) {
            //resource.moveIn(me);
            return CONTINUE;
        } else {
            Util.printPerIsStupidMessage("PickUp.doIt()");
            return DONE;
        }
    }
}
