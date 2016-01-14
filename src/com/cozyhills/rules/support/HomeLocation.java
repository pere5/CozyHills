package com.cozyhills.rules.support;

/**
 * Created by periks15 on 2016-01-14.
 */
public class HomeLocation {

    private final int[] location = new int[2];

    public HomeLocation(int x, int y) {
        location[0] = x;
        location[1] = y;
    }

    public int[] getLocation() {
        return location;
    }
}
