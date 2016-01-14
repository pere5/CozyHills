package com.cozyhills.rules;

import com.cozyhills.cozy.Util;
import com.cozyhills.model.Person;
import com.cozyhills.actions.Action;
import com.cozyhills.rules.structure.RuleHelper;

import java.util.Queue;

/**
 * Created by pere5 on 02/01/16.
 */
public class EmptyRule extends RuleHelper {

    public EmptyRule() {
        super(Integer.MAX_VALUE);
    }

    @Override
    public int calculateStatus(Person me) {
        return Integer.MAX_VALUE;
    }

    @Override
    public Queue<Action> initWork(Person me, int status, Queue<Action> actionList) {
        return null;
    }

    @Override
    public boolean work(Person me, Queue<Action> actionList) {
        return false;
    }

    @Override
    public void printStatus(int status) {
        Util.print(status);
    }
}
