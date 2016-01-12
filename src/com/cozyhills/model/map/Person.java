package com.cozyhills.model.map;

import com.cozyhills.Util;
import com.cozyhills.model.Rule;
import com.cozyhills.model.VisibleEntity;
import com.cozyhills.model.idea.Path;
import com.cozyhills.model.map.person.Home;
import com.cozyhills.model.map.person.CozyUp;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pere5 on 21/12/15.
 */
public class Person extends VisibleEntity {

    public static List<Rule> rules = new ArrayList<>();
    private List<Person> targets = new ArrayList<>();

    static {
        int rank = Integer.MAX_VALUE;
        rules.add(new CozyUp(rank--));
        rules.add(new Home(rank));
    }

    private boolean working = false;
    private Rule selectedRule = null;
    private Path path = null;

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

    public static List<Rule> getRules() {
        return rules;
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
}
