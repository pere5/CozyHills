package com.cozyhills.actions;

import com.cozyhills.model.Home;
import com.cozyhills.model.Person;

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
