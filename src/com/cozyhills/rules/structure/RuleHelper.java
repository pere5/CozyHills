package com.cozyhills.rules.structure;

import com.cozyhills.cozy.StateHolder;
import com.cozyhills.model.Person;
import com.cozyhills.model.VisibleEntity;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by pere5 on 02/01/16.
 */
public abstract class RuleHelper implements Rule {

    private final int rank;

    public RuleHelper(int rank) {
        this.rank = rank;
    }

    @Override
    public int rank() {
        return rank;
    }

    protected int range(VisibleEntity visibleEntity, VisibleEntity me) {
        return (int)Math.sqrt(Math.pow((visibleEntity.x - me.x), 2) + Math.pow((visibleEntity.y - me.y), 2));
    }

    protected int[] centroid(List<VisibleEntity> visibleEntityList) {
        int[] centroid = { 0, 0 };

        for (VisibleEntity visibleEntity: visibleEntityList) {
            centroid[0] += visibleEntity.x;
            centroid[1] += visibleEntity.y;
        }

        int totalPoints = visibleEntityList.size();
        centroid[0] = centroid[0] / totalPoints;
        centroid[1] = centroid[1] / totalPoints;

        return centroid;
    }

    protected int[] randomDestination(Person me, int distance) {
        int r1 = 1 - ThreadLocalRandom.current().nextInt(0, 2 + 1);
        int r2 = 1 - ThreadLocalRandom.current().nextInt(0, 2 + 1);
        return new int[]{me.x + distance * r1, me.y + distance * r2};
    }

    public List<VisibleEntity> getPersons() {
        return StateHolder.instance().getPersons();
    }

    public List<VisibleEntity> getHomes() {
        return StateHolder.instance().getHomes();
    }

    public List<VisibleEntity> getTrees() {
        return StateHolder.instance().getTrees();
    }
}
