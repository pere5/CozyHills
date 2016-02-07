package com.cozyhills.actions;

import com.cozyhills.cozy.Util;
import com.cozyhills.things.Person;
import com.cozyhills.things.buildings.Home;

/**
 * Created by pere5 on 28/01/16.
 */
public class BuildHome extends Action {
    private final Class<? extends Home> homeClass;

    public BuildHome(Class<? extends Home> homeClass) {
        this.homeClass = homeClass;
    }

    @Override
    public boolean doIt(Person me) {
        Util.printNotImplemented("Build Home!");

        return false;
    }
}
