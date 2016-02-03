package com.cozyhills.actions;

import com.cozyhills.things.buildings.Home;
import com.cozyhills.things.Person;

/**
 * Created by pere5 on 30/01/16.
 */
public class MoveIn implements Action {
    Home home;

    public MoveIn(Home home) {
        this.home = home;
    }

    @Override
    public boolean doIt(Person me) {
        home.moveIn(me);
        return false;
    }
}
