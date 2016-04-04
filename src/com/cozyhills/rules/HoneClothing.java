package com.cozyhills.rules;

import com.cozyhills.things.Person;

import java.awt.*;

/**
 * Created by pere5 on 13/03/16.
 */
public class HoneClothing extends RuleHelper {
    public HoneClothing(int rank) {
        super(rank);
    }

    @Override
    public int assessStatus(Person me) {
        return 0;
    }

    @Override
    public void decideActions(Person me, int status) {

    }

    @Override
    public Color getColor() {
        return null;
    }
}
