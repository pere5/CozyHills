package com.cozyhills.actions;

import com.cozyhills.Const;
import com.cozyhills.cozy.Util;
import com.cozyhills.things.Person;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pere5 on 06/01/16.
 */
public class Path extends Action {
    private final Queue<double[]> path = new LinkedList<>();
    private final int id = 3;

    public Path(double[] start, double[] destination) {
        double[] nextStep;
        while (!closeEnough(start, destination, Const.STEP)) {
            double vx = destination[0] - start[0];
            double vy = destination[1] - start[1];

            double mag = Math.sqrt(vx * vx + vy * vy);

            vx /= mag;
            vy /= mag;
            double px = (start[0] + vx * Const.STEP);
            double py = (start[1] + vy * Const.STEP);
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
}
