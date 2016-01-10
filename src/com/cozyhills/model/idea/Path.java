package com.cozyhills.model.idea;

import com.cozyhills.Util;
import com.cozyhills.model.map.Person;

import java.util.*;

/**
 * Created by pere5 on 06/01/16.
 */
public class Path {
    int step = 3;
    int closeEnough = 5;
    Queue<int[]> path = new LinkedList<>();

    public Path(int[] start, int[] destination) {
        int[] nextStep = new int [2];
        while (!arrived(nextStep, destination)) {
            double vx = destination[0] - start[0];
            double vy = destination[1] - start[1];

            double mag = Math.sqrt(vx * vx + vy * vy);

            vx /= mag;
            vy /= mag;
            int px = (int) (((double) start[0]) + (vx * ((double) step)));
            int py = (int) (((double) start[1]) + (vy * ((double) step)));
            nextStep = new int[] {px, py};
            path.add(nextStep);
            start = nextStep;
        }
        path.add(destination);
    }

    private boolean arrived(int[] pointA, int[] pointB) {
        int xBig = pointA[0] + closeEnough;
        int xSmall = pointA[0] - closeEnough;
        int yBig = pointA[1] + closeEnough;
        int ySmall = pointA[1] - closeEnough;
        return pointB[0] < xBig && pointB[0] > xSmall && pointB[1] < yBig && pointB[1] > ySmall;
    }

    public int[] nextStep() {
        return path.poll();
    }

    public boolean canContinue() {
        return path.size() > 0;
    }
}
