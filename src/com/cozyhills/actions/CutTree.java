package com.cozyhills.actions;

import com.cozyhills.model.Person;

/**
 * Created by pere5 on 14/01/16.
 */
public class CutTree implements Action {

    private int cut = 10;

    @Override
    public boolean doIt(Person me) {
        cut--;
        return cut > 0;
    }
}
