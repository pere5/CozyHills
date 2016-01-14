package com.cozyhills.model;

import com.cozyhills.cozy.Util;
import com.cozyhills.actions.Path;
import com.cozyhills.rules.structure.Rule;
import com.cozyhills.actions.Action;
import com.cozyhills.rules.support.HomeLocation;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by pere5 on 21/12/15.
 */
public class Person extends VisibleEntity {

    private List<VisibleEntity> targets = new ArrayList<>();
    private boolean working = false;
    private Rule selectedRule = null;
    private Home home = new Home();
    private Queue<Action> actionList = null;

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
        this.color = Color.PINK;
    }

    public boolean working() {
        return working;
    }

    public void work() {
        working = selectedRule.work(this, actionList);
    }

    public void startWorking(Rule selectedRule, int status) {
        actionList = selectedRule.initWork(this, status);
        this.selectedRule = selectedRule;
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

    public Queue<Action> getActionList() {
        return actionList;
    }

    public void setActionList(Queue<Action> actionList) {
        this.actionList = actionList;
    }

}
