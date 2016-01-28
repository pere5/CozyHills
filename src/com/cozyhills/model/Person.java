package com.cozyhills.model;

import com.cozyhills.cozy.Util;
import com.cozyhills.rules.support.Rule;
import com.cozyhills.actions.Action;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by pere5 on 21/12/15.
 */
public class Person extends VisibleEntity {

    private final List<VisibleEntity> targets = new ArrayList<>();
    private final Queue<Action> actionQueue = new LinkedList<>();
    private Home home = new Home();
    private Rule currentRule = null;

    public Person () {
        setDefaults();
        this.x = Util.generateWidth();
        this.y = Util.generateHeight();
    }

    public Person (int x, int y) {
        setDefaults();
        this.x = x;
        this.y = y;
    }

    private void setDefaults() {
        this.size = 3;
        this.color = Color.BLACK;
    }

    public boolean working() {
        return actionQueue.size() > 0;
    }

    public void work() {
        actionQueue.peek().doIt(this, actionQueue);
    }

    public void startWorking(Rule selectedRule, int status) {
        currentRule = selectedRule;
        selectedRule.initWork(this, status, actionQueue);
    }

    public void addTarget(VisibleEntity visibleEntity) {
        targets.add(visibleEntity);
    }

    public void clearTarget() {
        targets.clear();
    }

    public List<VisibleEntity> getTargets() {
        return targets;
    }

    public Home getHome() {
        return home;
    }

    public Rule getCurrentRule () {
        return currentRule;
    }
}
