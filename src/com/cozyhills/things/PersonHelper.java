package com.cozyhills.things;

import com.cozyhills.actions.Action;
import com.cozyhills.rules.Rule;
import com.cozyhills.things.buildings.Home;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by pere5 on 12/03/16.
 */
public abstract class PersonHelper extends VisibleEntity {

    private Set<VisibleEntity> targets = new HashSet<>();
    private Queue<Action> actionQueue = new LinkedList<>();
    private Set<Home> visitedHomes = new HashSet<>();
    private int searchForHome = 1;
    private Rule selectedRule;

    public boolean working() {
        return actionQueue.size() > 0;
    }

    public void work() {
        boolean continueWorking = actionQueue.peek().doIt((Person)this);
        if (!continueWorking) {
            Action completed = actionQueue.poll();
        }
    }

    public void startWorking(Rule selectedRule, int status) {
        this.selectedRule = selectedRule;
        selectedRule.initWork((Person)this, status);
    }

    public boolean searchForHome() {
        searchForHome--;
        return searchForHome >= 0;
    }

    public Rule getCurrentRule() {
        return selectedRule;
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

    public Queue<Action> getActionQueue() {
        return actionQueue;
    }

    public void visited(Home home) {
        visitedHomes.add(home);
    }

    public boolean notVisited(Home home) {
        return !visitedHomes.contains(home);
    }
}
