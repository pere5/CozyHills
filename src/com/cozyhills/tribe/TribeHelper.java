package com.cozyhills.tribe;

import com.cozyhills.things.Person;
import com.cozyhills.things.buildings.Building;
import com.cozyhills.things.items.Item;
import com.cozyhills.things.resources.Resource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by pere5 on 14/03/16.
 */
public abstract class TribeHelper {
    protected Person ruler;
    protected Set<Person> tribePeople = new HashSet<>();
    protected Map<Class<? extends Item>, Integer> storage = new HashMap<>();
    protected Set<Tribe> neighboringTribes = new HashSet<>();
    protected Set<Resource> ownedResources = new HashSet<>();
    protected Set<Building> buildings = new HashSet<>();
    protected int status;

    public int assessStatus() {
        int numberOfPeople = tribePeople.size();
        int valueOfStorage = storage.values().stream().reduce(0, (a, b) -> a + b);
        int valueOfResources = ownedResources.size();
        int valueOfBuildings = buildings.stream().mapToInt(Building::getStatus).sum();
        status = numberOfPeople + valueOfBuildings + valueOfResources + valueOfStorage;
        return status;
    }

    public Set<Tribe> getNeighboringTribes() {
        return neighboringTribes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
