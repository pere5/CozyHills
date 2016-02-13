package com.cozyhills.actions;

import com.cozyhills.cozy.Util;
import com.cozyhills.things.Person;
import com.cozyhills.things.buildings.Building;
import com.cozyhills.things.items.Item;

import java.util.Map;
import java.util.Optional;

/**
 * Created by pere5 on 28/01/16.
 */
public class Build extends Action {
    private final Building building;
    private final Item item;
    private final int id = 7;

    public Build(Building building, Item item) {
        this.building = building;
        this.item = item;
    }

    @Override
    public boolean doIt(Person me) {
        Util.printActionId(id);
        building.buildWith(item);
        return DONE;
    }
}
