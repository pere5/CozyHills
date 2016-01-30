package com.cozyhills.actions;

import com.cozyhills.model.Home;
import com.cozyhills.model.Person;

/**
 * Created by pere5 on 30/01/16.
 */
public class MoveIn implements Action {
    Home closestHome;

    public MoveIn(Home closestHome) {
        this.closestHome = closestHome;
    }

    @Override
    public boolean doIt(Person me) {
        return false;
    }
}
