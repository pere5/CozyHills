package com.cozyhills.rules;

import com.cozyhills.model.Person;

/**
 * Created by pere5 on 02/01/16.
 */
public interface Rule {

    int calculateStatus(Person me);
    boolean work(Person me);
    void printStatus(int status);

    void initWork(Person me, int status);

    int rank();
}
