package com.cozyhills.model;

import java.awt.*;

/**
 * Created by pere5 on 23/12/15.
 */
public abstract class VisibleEntity {
    private final int id;
    public int[] xy = new int[2];
    public int size = 0;
    public Color color = null;

    protected VisibleEntity(int id) {
        this.id = id;
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
