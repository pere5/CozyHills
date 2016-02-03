package com.cozyhills.actions;

import com.cozyhills.things.buildings.BasicHut;
import com.cozyhills.things.Person;
import com.cozyhills.things.items.Item;

/**
 * Created by pere5 on 28/01/16.
 */
public class Build implements Action {
    public Build(Class<BasicHut> basicHutClass, Item resource) {

    }

    @Override
    public boolean doIt(Person me) {
        return false;
    }
}
