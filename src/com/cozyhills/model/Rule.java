package com.cozyhills.model;

import com.cozyhills.model.map.Person;

import java.util.List;

/**
 * Created by pere5 on 02/01/16.
 */
public interface Rule {

    int calculate(Person me);
    boolean work(Person me);
    void printStatus(int newStatus);

    void initWork(Person me);
}
