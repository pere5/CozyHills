package com.cozyhills.cozy;

import com.cozyhills.things.Person;
import com.cozyhills.things.VisibleEntity;
import com.cozyhills.things.buildings.MudHut;
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

    private static final Set<Set<? extends Home>> HOME_SET = new HashSet<>();
    private static final Set<Set<? extends Building>> BUILDING_SET = new HashSet<>();
    private static final Set<Set<? extends Item>> ITEM_SET = new HashSet<>();
    private static final Set<Set<? extends Resource>> RESOURCE_SET = new HashSet<>();

    private static final Set<Person> PERSONS = new HashSet<>();
    private static final Set<MudHut> MUD_HUTS = new HashSet<>();
    private static final Set<Rock> ROCKS = new HashSet<>();
    private static final Set<Tree> TREES = new HashSet<>();
    private static final Set<Stone> STONES = new HashSet<>();
    private static final Set<Wood> WOODS = new HashSet<>();
    private static final Set<Clothes> CLOTHES = new HashSet<>();
    private static final Set<Food> FOODS = new HashSet<>();

    static {
        STATE.put(Person.class, PERSONS);
        STATE.put(MudHut.class, MUD_HUTS);
        STATE.put(Rock.class, ROCKS);
        STATE.put(Tree.class, TREES);
        STATE.put(Stone.class, STONES);
        STATE.put(Wood.class, WOODS);
        STATE.put(Clothes.class, CLOTHES);
        STATE.put(Food.class, FOODS);

        HOME_SET.add(MUD_HUTS);

        BUILDING_SET.add(MUD_HUTS);

        ITEM_SET.add(STONES);
        ITEM_SET.add(WOODS);
        ITEM_SET.add(CLOTHES);
        ITEM_SET.add(FOODS);

        RESOURCE_SET.add(ROCKS);
        RESOURCE_SET.add(TREES);

        createPersons(PERSONS);
        createTrees(TREES);
        createRocks(ROCKS);
        createBasicHuts(MUD_HUTS);
    }

    public static Map<Class, Set<? extends VisibleEntity>> getState() {
        return STATE;
    }

    public static void addVisibleEntity(VisibleEntity visibleEntity) {
        ((Set)(STATE.get(visibleEntity.getClass()))).add(visibleEntity);
    }

    private static void createBasicHuts(Set<MudHut> mudHuts) {
        for (int i = 0; i < 8; i++) {
            mudHuts.add(new MudHut());
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
        return HOME_SET.stream().flatMap(Collection::stream).collect(Collectors.toSet());
    }

    public static Set<? extends VisibleEntity> getEntities(Class classType) {
        return STATE.get(classType);
    }

    public static int getNewId() {
        return idGenerator++;
    }

    public static void removeVisibleEntity(VisibleEntity visibleEntity) {
        STATE.get(visibleEntity.getClass()).remove(visibleEntity);
    }
}
