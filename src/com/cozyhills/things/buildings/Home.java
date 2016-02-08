package com.cozyhills.things.buildings;

import com.cozyhills.things.Person;

import java.util.Map;

/**
 * Created by periks15 on 2016-01-13.
 */
public abstract class Home extends Building {

    private final Person[] tenants;
    private int takenRooms = 0;

    public Home(final int ROOMS, final int STATUS, final Map<Class, Integer> BUILD_COST, double[] position) {
        super(STATUS, BUILD_COST, position);
        tenants = new Person[ROOMS];
    }

    public Home(final int rooms, final int STATUS) {
        super(STATUS);
        tenants = new Person[rooms];
    }

    public void moveIn(Person me) {
        if (takenRooms < tenants.length) {
            for (int i = 0; i < tenants.length; i++) {
                if (tenants[i] == null) {
                    tenants[i] = me;
                    takenRooms++;
                    me.setHome(this);
                    return;
                }
            }
        }
    }
}
