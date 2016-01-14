package com.cozyhills.model;

/**
 * Created by periks15 on 2016-01-13.
 */
public class Home extends VisibleEntity {

    private int status = 1;

    public boolean exists() {
        return false;
    }

    public int getStatus() {
        return status;
    }
}
