package com.cozyhills.rules.structure;

import com.cozyhills.model.Person;
import com.cozyhills.actions.Action;

import java.util.List;
import java.util.Queue;

/**
 * Created by pere5 on 02/01/16.
 */
public interface Rule {

    int calculateStatus(Person me);
    boolean work(Person me);
    void printStatus(int status);

    Queue<Action> initWork(Person me, int status);

    int rank();
}
