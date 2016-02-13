package com.cozyhills.actions;

import com.cozyhills.cozy.StateHolder;
import com.cozyhills.cozy.Util;
import com.cozyhills.things.Person;
import com.cozyhills.things.items.Item;

/**
 * Created by periks15 on 2016-02-02.
 */
public class PickUp extends Action {
    private final Item item;
    private final int id = 2;

    public PickUp(Item item) {
        this.item = item;
    }

    @Override
    public boolean doIt(Person me) {
        Util.printActionId(id);
        if (closeEnough(me.xy, item.xy, Path.STEP)) {
            me.carry(item);
            StateHolder.removeVisibleEntity(item);
            return DONE;
        } else {
            Util.printPerIsStupidMessage("PickUp.doIt()");
            return DONE;
        }
    }
}
