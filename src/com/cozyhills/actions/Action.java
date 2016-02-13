package com.cozyhills.actions;

import com.cozyhills.things.Person;

/**
 * Created by periks15 on 2016-01-14.
 */
public abstract class Action {

    public static final boolean CONTINUE = true;
    public static final boolean DONE = false;

    protected boolean closeEnough(double[] pointA, double[] pointB, double step) {
        double xBig = pointA[0] + step;
        double xSmall = pointA[0] - step;
        double yBig = pointA[1] + step;
        double ySmall = pointA[1] - step;
        return pointB[0] < xBig && pointB[0] > xSmall && pointB[1] < yBig && pointB[1] > ySmall;
    }
    abstract public boolean doIt(Person me);
}
