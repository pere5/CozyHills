package com.cozyhills.rules;

import com.cozyhills.things.Person;

import java.awt.*;

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
    public void initWork(Person me, int status) {

    }

    @Override
    public Color getColor() {
        return Color.CYAN;
    }
}
