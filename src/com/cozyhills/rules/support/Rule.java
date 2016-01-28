package com.cozyhills.rules.support;

import com.cozyhills.actions.Action;
import com.cozyhills.model.Person;

import java.util.Queue;

/**
 * Created by pere5 on 02/01/16.
 */
public interface Rule {

    int calculateStatus(Person me);
    void printInfo(int status);

    void initWork(Person me, int status, Queue<Action> actionQueue);

    int rank();
    int id();
}
