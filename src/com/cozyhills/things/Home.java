package com.cozyhills.things;

import java.awt.*;

/**
 * Created by periks15 on 2016-01-13.
 */
public abstract class Home extends Building {

    private final Person[] tenants;
    private int takenRooms = 0;

    public Home(final int ROOMS, final int STATUS) {
        super(STATUS);
        tenants = new Person[ROOMS];
        setDefaults();
    }

    private void setDefaults() {
        this.size = 20;
        this.color = Color.PINK;
    }

    public boolean availableRooms() {
        return takenRooms < tenants.length;
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
