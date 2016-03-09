package com.cozyhills.ideas.settlements;

import com.cozyhills.ideas.Idea;

/**
 * Created by pere5 on 07/03/16.
 */
public abstract class Settlement extends Idea {

    private double[] position;
    private int status;

    public double[] getGatheringSpot() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
