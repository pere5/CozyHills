package com.cozyhills.rules.support;

import com.cozyhills.cozy.StateHolder;
import com.cozyhills.cozy.Util;
import com.cozyhills.things.*;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by pere5 on 02/01/16.
 */
public abstract class RuleHelper implements Rule {

    private final int rank;
    protected final int id;

    public RuleHelper(int rank) {
        this.rank = rank;
        this.id = Integer.MAX_VALUE - rank;
    }

    @Override
    public int rank() {
        return rank;
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public void printInfo(int status) {
        Util.print(id + ":" + status);
    }

    protected int range(VisibleEntity visibleEntity, VisibleEntity me) {
        return (int)Math.sqrt(Math.pow((visibleEntity.xy[0] - me.xy[0]), 2) + Math.pow((visibleEntity.xy[1] - me.xy[1]), 2));
    }

    protected int rangeSimplified(VisibleEntity visibleEntity, VisibleEntity me) {
        return (int)(Math.pow((visibleEntity.xy[0] - me.xy[0]), 2) + Math.pow((visibleEntity.xy[1] - me.xy[1]), 2));
    }

    protected int[] centroid(Set<VisibleEntity> visibleEntityList) {
        int[] centroid = { 0, 0 };

        for (VisibleEntity visibleEntity: visibleEntityList) {
            centroid[0] += visibleEntity.xy[0];
            centroid[1] += visibleEntity.xy[1];
        }

        int totalPoints = visibleEntityList.size();
        centroid[0] = centroid[0] / totalPoints;
        centroid[1] = centroid[1] / totalPoints;

        return centroid;
    }

    protected int[] randomDestination(Person me, final int DISTANCE) {
        int r1 = 1 - ThreadLocalRandom.current().nextInt(0, 2 + 1);
        int r2 = 1 - ThreadLocalRandom.current().nextInt(0, 2 + 1);
        return new int[]{me.xy[0] + DISTANCE * r1, me.xy[1] + DISTANCE * r2};
    }

    protected Rock getClosestVisibleRock(Person me, final int VISIBLE_ZONE) {
        return (Rock)getClosestVisibleEntity(me, VISIBLE_ZONE, Rock.class);
    }

    protected Tree getClosestVisibleTree(Person me, final int VISIBLE_ZONE) {
        return (Tree)getClosestVisibleEntity(me, VISIBLE_ZONE, Tree.class);
    }

    protected Home getClosestVisibleHome(Person me, final int VISIBLE_ZONE) {
        return (Home)getClosestVisibleEntity(me, VISIBLE_ZONE, Home.class);
    }

    protected Optional<Home> getClosestUnvisitedVisibleHome(Person me, final int VISIBLE_ZONE) {
        Set<Home> visitedHomes = me.getVisitedHomes();
        Set<Home> allHomes = getHomes();
        return allHomes.stream().parallel()
                .filter(home -> !visitedHomes.contains(home))
                .min((home1, home2) -> rangeSimplified(me, home1) - rangeSimplified(me, home2))
                .map(result -> rangeSimplified(me, result) <= VISIBLE_ZONE ? result : null);
    }

    private VisibleEntity getClosestVisibleEntity(Person me, final int VISIBLE_ZONE, Class<?> type) {
        VisibleEntity closestEntity = null;
        Integer closestRange = Integer.MAX_VALUE;
        for (VisibleEntity entity: getEntityList(type)) {
            int range = range(me, entity);
            if (range < closestRange) {
                closestRange = range;
                if (closestRange < VISIBLE_ZONE) {
                    closestEntity = entity;
                }
            }
        }
        return closestEntity;
    }

    private Set<? extends VisibleEntity> getEntityList(Class<?> entity) {
        return StateHolder.instance().getEntities(entity);
    }

    protected Set<Person> getPersons() {
        return StateHolder.instance().getPersons();
    }

    protected Set<Home> getHomes() {
        return StateHolder.instance().getHomes();
    }

    protected Set<Tree> getTrees() {
        return StateHolder.instance().getTrees();
    }

    protected Set<Rock> getRocks() {
        return StateHolder.instance().getRocks();
    }
}
