package com.cozyhills.actions;

import com.cozyhills.things.Person;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pere5 on 06/01/16.
 */
public class Path implements Action {
    private static final double STEP = 2;
    private static final double CLOSE_ENOUGH = 1.5;
    private final Queue<double[]> path = new LinkedList<>();

    public Path(double[] start, double[] destination) {
        double[] nextStep;
        while (!arrived(start, destination)) {
            double vx = destination[0] - start[0];
            double vy = destination[1] - start[1];

            double mag = Math.sqrt(vx * vx + vy * vy);

            vx /= mag;
            vy /= mag;
            double px = (start[0] + vx * STEP);
            double py = (start[1] + vy * STEP);
            nextStep = new double[] {px, py};
            path.add(nextStep);
            start = nextStep;
        }
        path.add(destination);
    }

    @Override
    public boolean doIt(Person me) {
        me.xy = path.poll();
        return path.size() > 0;
    }

    private boolean arrived(double[] pointA, double[] pointB) {
        double xBig = pointA[0] + CLOSE_ENOUGH;
        double xSmall = pointA[0] - CLOSE_ENOUGH;
        double yBig = pointA[1] + CLOSE_ENOUGH;
        double ySmall = pointA[1] - CLOSE_ENOUGH;
        return pointB[0] < xBig && pointB[0] > xSmall && pointB[1] < yBig && pointB[1] > ySmall;
    }
}
