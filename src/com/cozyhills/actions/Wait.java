package com.cozyhills.actions;

import com.cozyhills.model.Person;

/**
 * Created by pere5 on 14/01/16.
 */
public class Wait implements Action {

    private int wait;

    public Wait(int frames) {
        wait = frames;
    }

    @Override
    public boolean doIt(Person me) {
        wait--;
        return wait > 0;
    }
}
