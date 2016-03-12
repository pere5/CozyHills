package com.cozyhills.cozy;

import com.cozyhills.things.Person;
import com.cozyhills.things.VisibleEntity;
import com.cozyhills.things.buildings.Hut;
import com.cozyhills.things.buildings.Building;
import com.cozyhills.things.buildings.Home;
import com.cozyhills.things.items.*;
import com.cozyhills.things.resources.Resource;
import com.cozyhills.things.resources.Rock;
import com.cozyhills.things.resources.Tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by pere5 on 23/12/15.
 */
public class StateHolder {

    private static int idGenerator = 0;

    private static final Map<Class, Set<? extends VisibleEntity>> STATE = new HashMap<>();

    private static final Set<Set<? extends Home>> HOMES = new HashSet<>();
    private static final Set<Set<? extends Building>> BUILDINGS = new HashSet<>();
    private static final Set<Set<? extends Item>> ITEMS = new HashSet<>();
    private static final Set<Set<? extends Resource>> RESOURCES = new HashSet<>();

    //Persons
    private static final Set<Person> PERSONS = new HashSet<>();

    //Buildings
    private static final Set<Hut> HUTS = new HashSet<>();

    //Resources
    private static final Set<Rock> ROCKS = new HashSet<>();
    private static final Set<Tree> TREES = new HashSet<>();

    //Items
    private static final Set<Stone> STONES = new HashSet<>();
    private static final Set<Wood> WOOD = new HashSet<>();
    private static final Set<Clothes> CLOTHES = new HashSet<>();
    private static final Set<Food> FOOD = new HashSet<>();

    static {
        STATE.put(Person.class, PERSONS);
        STATE.put(Hut.class, HUTS);
        STATE.put(Rock.class, ROCKS);
        STATE.put(Tree.class, TREES);
        STATE.put(Stone.class, STONES);
        STATE.put(Wood.class, WOOD);
        STATE.put(Clothes.class, CLOTHES);
        STATE.put(Food.class, FOOD);

        HOMES.add(HUTS);

        BUILDINGS.add(HUTS);

        ITEMS.add(STONES);
        ITEMS.add(WOOD);
        ITEMS.add(CLOTHES);
        ITEMS.add(FOOD);

        RESOURCES.add(ROCKS);
        RESOURCES.add(TREES);

        createPersons(PERSONS);
        createTrees(TREES);
        createRocks(ROCKS);
        createBasicHuts(HUTS);
    }

    public static Map<Class, Set<? extends VisibleEntity>> getState() {
        return STATE;
    }

    private static void createBasicHuts(Set<Hut> huts) {
        for (int i = 0; i < 8; i++) {
            huts.add(new Hut());
        }
    }

    private static void createTrees(Set<Tree> trees) {
        for (int i = 0; i < 40; i++) {
            trees.add(new Tree());
        }
    }

    private static void createRocks(Set<Rock> rocks) {
        for (int i = 0; i < 40; i++) {
            rocks.add(new Rock());
        }
    }

    private static void createPersons(Set<Person> persons) {
        for (int i = 0; i < 40; i++) {
            persons.add(new Person());
        }
    }

    public static Set<Person> getPersons() {
        return PERSONS;
    }

    public static Set<Home> getHomes() {
        return HOMES.stream().flatMap(Collection::stream).collect(Collectors.toSet());
    }

    public static Set<? extends VisibleEntity> getEntities(Class classType) {
        return STATE.get(classType);
    }

    public static int getNewId() {
        return idGenerator++;
    }

    public static void addVisibleEntity(VisibleEntity visibleEntity) {
        ((Set)(STATE.get(visibleEntity.getClass()))).add(visibleEntity);
    }

    public static void removeVisibleEntity(VisibleEntity visibleEntity) {
        STATE.get(visibleEntity.getClass()).remove(visibleEntity);
    }
}
