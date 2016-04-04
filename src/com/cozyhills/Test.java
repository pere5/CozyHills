package com.cozyhills;

import com.cozyhills.cozy.StateHolder;
import com.cozyhills.things.Person;
import com.cozyhills.things.buildings.Building;
import com.cozyhills.things.buildings.Hut;
import com.cozyhills.things.items.Food;
import com.cozyhills.things.items.Stone;
import com.cozyhills.things.items.Wood;
import com.cozyhills.tribe.Tribe;

import java.util.*;

/**
 * Created by pere5 on 15/03/16.
 */
public class Test {
    public static void main(String[] args) {
        Map<Class, Integer> map = new HashMap<>();
        map.put(Wood.class, 3);
        map.put(Stone.class, 3);
        map.put(Food.class, 3);
        Integer valueOfStorage = map.values().stream().reduce(0, (a, b) -> a + b);

        Set<Building> buildings = new HashSet<>();
        buildings.add(new Hut());
        long valueOfBuildings = buildings.stream().mapToInt(Building::getStatus).sum();

        int counter = 0;
        List<Tribe> tribes = new ArrayList<>();
        for (int i = 0; i < 130; i++) {
            tribes.add(new Tribe(new Person()));
        }
        for (int i = 0; i < 24; i++) {
            int tenthOfCurrent = tribes.size() / 10;
            int roof = counter + tenthOfCurrent;
            roof = Math.min(roof, tribes.size());
            while (counter < roof) {
                counter++;
                System.out.print(counter + " ");
                /*Tribe tribe = tribes.get(counter);
                tribe.assessStatus();
                tribe.considerTribalUnification();
                tribe.considerTrade();
                tribe.considerWar();
                tribe.considerMigration();
                tribe.considerOccupations();*/
            }
            System.out.println();
            if (counter == tribes.size()) {
                counter = 0;
            }
        }

        System.out.println();
        System.out.println(valueOfStorage);
        System.out.println(valueOfBuildings);
    }
}
