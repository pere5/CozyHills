package com.cozyhills.cozy;

import com.cozyhills.things.Person;
import com.cozyhills.things.VisibleEntity;
import com.cozyhills.things.buildings.BasicHut;
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

    private static final Map<Class, Set<? extends VisibleEntity>> state = new HashMap<>();

    private static final Set<Set<? extends Home>> homeSet = new HashSet<>();
    private static final Set<Set<? extends Building>> buildingSet = new HashSet<>();
    private static final Set<Set<? extends Item>> itemSet = new HashSet<>();
    private static final Set<Set<? extends Resource>> resourceSet = new HashSet<>();

    private static final Set<Person> persons = new HashSet<>();
    private static final Set<BasicHut> basicHuts = new HashSet<>();
    private static final Set<Rock> rocks = new HashSet<>();
    private static final Set<Tree> trees = new HashSet<>();
    private static final Set<Stone> stones = new HashSet<>();
    private static final Set<Wood> woods = new HashSet<>();
    private static final Set<Clothes> clothes = new HashSet<>();
    private static final Set<Food> food = new HashSet<>();

    static {
        state.put(Person.class, persons);
        state.put(BasicHut.class, basicHuts);
        state.put(Rock.class, rocks);
        state.put(Tree.class, trees);
        state.put(Stone.class, stones);
        state.put(Wood.class, woods);
        state.put(Clothes.class, clothes);
        state.put(Food.class, food);

        homeSet.add(basicHuts);

        buildingSet.add(basicHuts);

        itemSet.add(stones);
        itemSet.add(woods);
        itemSet.add(clothes);
        itemSet.add(food);

        resourceSet.add(rocks);
        resourceSet.add(trees);

        createPersons(persons);
        createTrees(trees);
        createRocks(rocks);
        createBasicHuts(basicHuts);
    }

    public static Map<Class, Set<? extends VisibleEntity>> getState() {
        return state;
    }

    public static void addVisibleEntity(VisibleEntity visibleEntity) {
        ((Set)(state.get(visibleEntity.getClass()))).add(visibleEntity);
    }

    private static void createBasicHuts(Set<BasicHut> basicHuts) {
        for (int i = 0; i < 8; i++) {
            basicHuts.add(new BasicHut());
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
        return persons;
    }

    public static Set<Home> getHomes() {
        return homeSet.stream().flatMap(Collection::stream).collect(Collectors.toSet());
    }

    public static Set<? extends VisibleEntity> getEntities(Class classType) {
        return state.get(classType);
    }

    public static int getNewId() {
        return idGenerator++;
    }

    public static void removeVisibleEntity(VisibleEntity visibleEntity) {
        state.get(visibleEntity.getClass()).remove(visibleEntity);
    }
}
