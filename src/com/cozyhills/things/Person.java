package com.cozyhills.things;

import com.cozyhills.cozy.StateHolder;
import com.cozyhills.things.buildings.Home;
import com.cozyhills.things.items.Item;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by pere5 on 21/12/15.
 */
public class Person extends PersonHelper {

    //In game values
    private Map<Class, Integer> experience = new HashMap<>();
    private Optional<Home> home = Optional.empty();
    private Optional<Item> carrying = Optional.empty();
    private Optional<double[]> safeSpot = Optional.empty();

    public Person () {
        super();
        setDefaults();
    }

    private void setDefaults() {
        this.size = 3;
        this.color = Color.BLACK;
    }

    public Optional<Home> getHome() {
        return home;
    }

    public void moveIn(Home home) {
        this.home = Optional.of(home);
    }

    public Optional<Item> getAnCarryingItemOfTypes(Map<Class<? extends Item>, Integer> items) {
        if (carrying.isPresent() && items.get(carrying.get().getClass()) != null) {
            Optional<Item> item = carrying;
            carrying = Optional.empty();
            return item;
        } else {
            return Optional.empty();
        }
    }

    public Optional<Item> carrying() {
        return carrying;
    }

    public void safeSpot(double[] safeSpot) {
        if (!this.safeSpot.isPresent()) {
            this.safeSpot = Optional.of(safeSpot);
        }
    }

    public Optional<double[]> getSafeSpot() {
        return home.isPresent() ? Optional.of(home.get().xy) : safeSpot;
    }

    public void carry(Item item) {
        carrying = Optional.of(item);
    }

    public void levelUp(Item item) {
        Integer level = experience.get(item.getClass());
        if (level == null) {
            experience.put(item.getClass(), 1);
        } else {
            experience.put(item.getClass(), level + 1);
        }
    }

    public void dropCarrying() {
        if (carrying.isPresent()) {
            Item item = carrying.get();
            item.xy = this.xy;
            StateHolder.addVisibleEntity(item);
            carrying = Optional.empty();
        }
    }
}
