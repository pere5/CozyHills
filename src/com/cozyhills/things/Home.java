package com.cozyhills.things;

import com.cozyhills.cozy.Util;

import java.awt.*;

/**
 * Created by periks15 on 2016-01-13.
 */
public class Home extends VisibleEntity {

    private final Person[] tenants;
    private int status = 1;
    private int takenRooms = 0;

    public Home() {
        super();
        tenants = new Person[2];
        setDefaults();
        this.xy[0] = Util.generateWidth();
        this.xy[1] = Util.generateHeight();
    }

    public Home(final int ROOMS) {
        super();
        tenants = new Person[ROOMS];
    }

    private void setDefaults() {
        this.size = 20;
        this.color = Color.PINK;
    }

    public boolean exists() {
        return false;
    }

    public int getStatus() {
        return status;
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
