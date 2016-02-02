package com.cozyhills.things;

import com.cozyhills.cozy.Util;

import java.awt.*;

/**
 * Created by periks15 on 2016-01-13.
 */
public abstract class Home extends Building {

    private final Person[] tenants;
    private final int STATUS;
    private int takenRooms = 0;

    public Home(final int ROOMS, final int STATUS) {
        super();
        tenants = new Person[ROOMS];
        this.STATUS = STATUS;
        setDefaults();
    }

    private void setDefaults() {
        this.size = 20;
        this.color = Color.PINK;
    }

    public int getStatus() {
        return STATUS;
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
                    Util.print("MOVED IN!");
                    return;
                }
            }
        }
    }
}
