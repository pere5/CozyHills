package com.cozyhills.actions;

import com.cozyhills.cozy.Util;
import com.cozyhills.things.buildings.BasicHut;
import com.cozyhills.things.Person;
import com.cozyhills.things.buildings.Building;

/**
 * Created by pere5 on 28/01/16.
 */
public class Build extends Action {
    private final Class<? extends Building> buildingClass;

    public Build(Class<? extends Building> buildingClass) {
        this.buildingClass = buildingClass;
        Util.printNotImplemented("Build!");
    }

    @Override
    public boolean doIt(Person me) {
        return false;
    }
}
