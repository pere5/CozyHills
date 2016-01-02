package com.cozyhills.model.map;

import com.cozyhills.Util;
import com.cozyhills.model.Rule;
import com.cozyhills.model.VisibleEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pere5 on 21/12/15.
 */
public class Person extends VisibleEntity {

    public int status;

    public Person () {
        setDefaults();
        this.x = Util.generateWidth();
        this.y = Util.generateHeight();
    }

    public Person (int x, int y) {
        setDefaults();
        this.x = x;
        this.y = y;
    }

    private void setDefaults() {
        this.size = 3;
    }

    public List<Rule> getRules() {
        return new ArrayList<Rule>();
    }
}
