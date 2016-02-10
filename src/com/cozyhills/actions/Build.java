package com.cozyhills.actions;

import com.cozyhills.cozy.Util;
import com.cozyhills.things.Person;
import com.cozyhills.things.buildings.Building;
import com.cozyhills.things.buildings.Home;
import com.cozyhills.things.items.Item;

/**
 * Created by pere5 on 28/01/16.
 */
public class Build extends Action {
    private final Building building;
    private final Item item;

    public Build(Building building, Item item) {
        this.building = building;
        this.item = item;
    }

    @Override
    public boolean doIt(Person me) {
        building.buildWith(item);
        //ska jag sätta mitt hem här eller var?
        return DONE;
    }
}
