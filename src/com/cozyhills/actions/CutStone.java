package com.cozyhills.actions;

import com.cozyhills.model.Person;

/**
 * Created by periks15 on 2016-01-28.
 */
public class CutStone implements Action {

    private int cut = 10;

    @Override
    public boolean doIt(Person me) {
        cut--;
        return cut > 0;
    }
}

