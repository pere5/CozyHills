package com.cozyhills.model;

/**
 * Created by periks15 on 2016-01-13.
 */
public class Home extends VisibleEntity {

    private int status = 1;
    private final int ROOMS;
    private int takenRooms = 0;

    public Home() {
        this.ROOMS = 0;
    }

    public Home(final int ROOMS) {
        this.ROOMS = ROOMS;
    }

    public boolean exists() {
        return false;
    }

    public int getStatus() {
        return status;
    }

    public boolean availableRooms() {
        return takenRooms < ROOMS;
    }
}
