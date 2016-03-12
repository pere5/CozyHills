package com.cozyhills.things;

import com.cozyhills.Const;
import com.cozyhills.cozy.StateHolder;
import com.cozyhills.cozy.Util;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

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
        if (xy[0] == 0 && xy[1] == 0) {
            this.xy[0] = generateWidth();
            this.xy[1] = generateHeight();
        }
    }

    protected void removeVisibleEntity(VisibleEntity visibleEntity) {
        StateHolder.removeVisibleEntity(visibleEntity);
    }

    public static int generateHeight () {
        return Const.WINDOW_HEIGHT / 2 + generateInt();
    }

    public static int generateWidth () {
        return Const.WINDOW_WIDTH / 2 + generateInt();
    }

    private static int generateInt() {
        return 250 - ThreadLocalRandom.current().nextInt(0, 500 + 1);
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
