package com.cozyhills.actions;

import com.cozyhills.cozy.Util;
import com.cozyhills.things.Person;
import com.cozyhills.things.buildings.Home;
import com.cozyhills.things.items.Item;

import java.util.Optional;

/**
 * Created by pere5 on 28/01/16.
 */
public class BuildHome extends Action {
    private final Home home;
    private final Optional<Item> carryingItem;

    public BuildHome(Home home, Optional<Item> carryingItem) {
        this.home = home;
        this.carryingItem = carryingItem;
    }

    @Override
    public boolean doIt(Person me) {
        if (carryingItem == me.carrying()) {
            Item item = me.useCarryingItem();
            boolean finished = home.buildWith(item);
            return finished;
        } else {
            Util.printPerIsStupidMessage("BuildHome.doIt()");
            return DONE;
        }
    }
}
