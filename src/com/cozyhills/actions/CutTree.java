package com.cozyhills.actions;

import com.cozyhills.model.Person;
import com.cozyhills.model.Tree;

/**
 * Created by periks15 on 2016-01-14.
 */
public class CutTree implements Action {

    private int cut = 10;
    private Tree tree = null;

    public CutTree(Tree tree) {
        this.tree = tree;
    }

    @Override
    public boolean doIt(Person me) {
        cut--;
        return cut > 0;
    }
}
