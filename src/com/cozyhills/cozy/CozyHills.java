package com.cozyhills.cozy;

import com.cozyhills.model.GameType;

import java.util.List;

/**
 * Created by pere5 on 21/12/15.
 */
public class CozyHills {

    StateHolder stateHolder = new StateHolder();

    public static void update() {

    }

    public List<List<GameType>> getState() {
        return stateHolder.getState();
    }
}
