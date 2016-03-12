package com.cozyhills.rules;

import com.cozyhills.things.Person;

import java.awt.*;

/**
 * Created by pere5 on 02/01/16.
 */
public interface Rule {

    int calculateStatus(Person me);
    void printInfo(int status);

    void initWork(Person me, int status);

    int rank();
    int id();

    Color getColor();
}
