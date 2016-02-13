package com.cozyhills.actions;

import com.cozyhills.cozy.Util;
import com.cozyhills.things.Person;
import com.cozyhills.things.items.Item;
import com.cozyhills.things.resources.Resource;

import java.util.Optional;

/**
 * Created by pere5 on 31/01/16.
 */
public class Gather extends Action {
    private final Resource resource;
    private int turnsToGatherResource;
    private final int id = 5;

    public Gather(Resource resource) {
        this.resource = resource;
        this.turnsToGatherResource = resource.getTurnsToGather();
    }

    @Override
    public boolean doIt(Person me) {
        Util.printActionId(id);
        if (closeEnough(me.xy, resource.xy, Path.STEP) && !me.carrying().isPresent()) {
            turnsToGatherResource--;
            if (turnsToGatherResource < 0) {
                Optional<Item> item = resource.gathered();
                if (item.isPresent()) {
                    me.carry(item.get());
                    me.levelUp(item.get());
                }
                return DONE;
            } else {
                return CONTINUE;
            }
        } else {
            return DONE;
        }
    }
}
