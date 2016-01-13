package com.cozyhills.model;

import com.cozyhills.cozy.Util;
import com.cozyhills.idea.Path;
import com.cozyhills.rules.Rule;
import com.cozyhills.rules.SeekShelter;
import com.cozyhills.rules.CozyUp;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pere5 on 21/12/15.
 */
public class Person extends VisibleEntity {

    private List<Person> targets = new ArrayList<>();
    private boolean working = false;
    private Rule selectedRule = null;
    private Path path = null;
    private Home home = new Home();

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
        working = selectedRule.work(this);
    }

    public void startWorking(Rule selectedRule, int status) {
        selectedRule.initWork(this, status);
        this.selectedRule = selectedRule;
    }

    public void addTarget(Person person) {
        targets.add(person);
    }

    public void clearTarget() {
        targets.clear();
    }

    public List<Person> getTargets() {
        return targets;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return path;
    }

    public Home getHome() {
        return home;
    }
}
