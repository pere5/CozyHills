package com.cozyhills.model;

import com.cozyhills.model.map.Person;

import java.util.List;

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
