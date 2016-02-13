package com.cozyhills.things.items;

import com.cozyhills.things.resources.Resource;
import com.cozyhills.things.resources.Tree;

import java.awt.*;

/**
 * Created by pere5 on 28/01/16.
 */
public class Wood extends Item {

    public Wood () {
        super();
        setDefaults();
    }

    private void setDefaults() {
        this.size = 4;
        this.color = Color.decode("#8D87DE");
    }

    @Override
    public Class<Resource> getCorrespondingResourceType() {
        return (Class<Resource>)((Class<? extends Resource>)Tree.class);
    }
}
