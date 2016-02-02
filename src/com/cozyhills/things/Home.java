package com.cozyhills.things;

/**
 * Created by periks15 on 2016-01-13.
 */
public class Home extends VisibleEntity {

    private final Person[] tenants;
    private int status = 1;
    private int takenRooms = 0;

    public Home() {
        super();
        tenants = new Person[0];
    }

    public Home(final int ROOMS) {
        super();
        tenants = new Person[ROOMS];
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
