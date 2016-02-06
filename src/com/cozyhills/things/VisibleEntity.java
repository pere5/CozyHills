package com.cozyhills.things;

import com.cozyhills.Const;
import com.cozyhills.cozy.StateHolder;
import com.cozyhills.cozy.Util;

import java.awt.*;

/**
 * Created by pere5 on 23/12/15.
 */
public abstract class VisibleEntity {
    private final int id;
    public double[] xy = new double[2];
    public int size = 0;
    public Color color = null;
    public Const.SHAPES SHAPE = Const.SHAPES.RECT;

    protected VisibleEntity() {
        this.id = StateHolder.getNewId();
        this.xy[0] = Util.generateWidth();
        this.xy[1] = Util.generateHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisibleEntity)) return false;

        VisibleEntity that = (VisibleEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
