package com.cozyhills.things;

import com.cozyhills.actions.Action;
import com.cozyhills.cozy.StateHolder;
import com.cozyhills.rules.Rule;
import com.cozyhills.things.buildings.Home;
import com.cozyhills.things.items.Item;

import java.awt.*;
import java.util.*;
import java.util.Queue;

/**
 * Created by pere5 on 21/12/15.
 */
public class Person extends VisibleEntity {

    private final Set<VisibleEntity> targets = new HashSet<>();
    private final Queue<Action> actionQueue = new LinkedList<>();
    private final Map<Class, Integer> levels = new HashMap<>();
    private final Set<Home> visitedHomes = new HashSet<>();
    private Optional<Home> home = Optional.empty();
    private int searchForHome = 1;
    private Optional<Item> carrying = Optional.empty();
    private Optional<double[]> safeSpot = Optional.empty();
    private Rule selectedRule;

    public Person () {
        super();
        setDefaults();
    }

    private void setDefaults() {
        this.size = 3;
        this.color = Color.BLACK;
    }

    public boolean working() {
        return actionQueue.size() > 0;
    }

    public void work() {
        boolean continueWorking = actionQueue.peek().doIt(this);
        if (!continueWorking) {
            Action completed = actionQueue.poll();
        }
    }

    public void startWorking(Rule selectedRule, int status) {
        this.selectedRule = selectedRule;
        selectedRule.initWork(this, status);
    }

    public void addTarget(VisibleEntity visibleEntity) {
        targets.add(visibleEntity);
    }

    public void clearTarget() {
        targets.clear();
    }

    public Set<VisibleEntity> getTargets() {
        return targets;
    }

    public Optional<Home> getHome() {
        return home;
    }

    public boolean searchForHome() {
        searchForHome--;
        return searchForHome >= 0;
    }

    public Queue<Action> getActionQueue() {
        return actionQueue;
    }

    public void moveIn(Home home) {
        this.home = Optional.of(home);
    }

    public Optional<Item> getAnCarryingItemOfTypes(Map<Class<? extends Item>, Integer> items) {
        if (carrying.isPresent() && items.get(carrying.get().getClass()) != null) {
            Optional<Item> item = carrying;
            carrying = Optional.empty();
            return item;
        } else {
            return Optional.empty();
        }
    }

    public Optional<Item> carrying() {
        return carrying;
    }

    public void safeSpot(double[] safeSpot) {
        if (!this.safeSpot.isPresent()) {
            this.safeSpot = Optional.of(safeSpot);
        }
    }

    public Optional<double[]> getSafeSpot() {
        return home.isPresent() ? Optional.of(home.get().xy) : safeSpot;
    }

    public void carry(Item item) {
        carrying = Optional.of(item);
    }

    public void levelUp(Item item) {
        Integer level = levels.get(item.getClass());
        if (level == null) {
            levels.put(item.getClass(), 1);
        } else {
            levels.put(item.getClass(), level + 1);
        }
    }

    public void dropCarrying() {
        if (carrying.isPresent()) {
            Item item = carrying.get();
            item.xy = this.xy;
            StateHolder.addVisibleEntity(item);
            carrying = Optional.empty();
        }
    }

    public void visited(Home home) {
        visitedHomes.add(home);
    }

    public boolean notVisited(Home home) {
        return !visitedHomes.contains(home);
    }

    public Rule getCurrentRule() {
        return selectedRule;
    }
}
