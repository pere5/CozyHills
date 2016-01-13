package com.cozyhills.ideas;

import java.util.*;

/**
 * Created by pere5 on 06/01/16.
 */
public class Path {
    private static final int STEP = 3;
    private static final int CLOSE_ENOUGH = 5;
    Queue<int[]> path = new LinkedList<>();

    public Path(int[] start, int[] destination) {
        int[] nextStep;
        while (!arrived(start, destination)) {
            double vx = destination[0] - start[0];
            double vy = destination[1] - start[1];

            double mag = Math.sqrt(vx * vx + vy * vy);

            vx /= mag;
            vy /= mag;
            int px = (int)(start[0] + vx * STEP);
            int py = (int)(start[1] + vy * STEP);
            nextStep = new int[] {px, py};
            path.add(nextStep);
            start = nextStep;
        }
        path.add(destination);
    }

    private boolean arrived(int[] pointA, int[] pointB) {
        int xBig = pointA[0] + CLOSE_ENOUGH;
        int xSmall = pointA[0] - CLOSE_ENOUGH;
        int yBig = pointA[1] + CLOSE_ENOUGH;
        int ySmall = pointA[1] - CLOSE_ENOUGH;
        return pointB[0] < xBig && pointB[0] > xSmall && pointB[1] < yBig && pointB[1] > ySmall;
    }

    public int[] nextStep() {
        return path.poll();
    }

    public boolean canContinue() {
        return path.size() > 0;
    }
}
