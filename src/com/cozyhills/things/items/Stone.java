package com.cozyhills.things.items;

import com.cozyhills.things.VisibleEntity;
import com.cozyhills.things.resources.Resource;
import com.cozyhills.things.resources.Rock;

import java.awt.*;

/**
 * Created by pere5 on 28/01/16.
 */
public class Stone extends Item {

    public Stone () {
        super();
        setDefaults();
    }

    private void setDefaults() {
        this.size = 3;
        this.color = Color.decode("#DEB887");
    }

    @Override
    public Class<? extends Resource> getCorrespondingResource() {
        return Rock.class;
    }
}
