package com.cozyhills.things;

import com.cozyhills.actions.Action;
import com.cozyhills.cozy.Util;
import com.cozyhills.rules.support.Rule;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by pere5 on 21/12/15.
 */
public class Person extends VisibleEntity {

    private final Set<VisibleEntity> targets = new HashSet<>();
    private final Queue<Action> actionQueue = new LinkedList<>();
    private Set<Home> visitedHomes = new HashSet<>();
    private Home home = new Home();
    private Rule currentRule = null;
    private int searchForHome = 10;

    public Person () {
        super();
        setDefaults();
        this.xy[0] = Util.generateWidth();
        this.xy[1] = Util.generateHeight();
    }

    public Person (int x, int y) {
        super();
        setDefaults();
        this.xy[0] = x;
        this.xy[1] = y;
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
            Action discard = actionQueue.poll();
        }
    }

    public void startWorking(Rule selectedRule, int status) {
        currentRule = selectedRule;
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

    public Home getHome() {
        return home;
    }

    public Rule getCurrentRule () {
        return currentRule;
    }

    public boolean searchForHome() {
        searchForHome--;
        return searchForHome >= 0;
    }

    public Queue<Action> getActionQueue() {
        return actionQueue;
    }

    public Set<Home> getVisitedHomes() {
        return visitedHomes;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}
