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
    private final Class<? extends Home> homeClass;
    private final Optional<Item> carryingItem;

    public BuildHome(Class<? extends Home> homeClass, Optional<Item> carryingItem) {
        this.homeClass = homeClass;
        this.carryingItem = carryingItem;
    }

    @Override
    public boolean doIt(Person me) {
        if (carryingItem == me.carrying()) {

        } else {
            Util.printPerIsStupidMessage("BuildHome.doIt()");
            return false;
        }
    }
}
