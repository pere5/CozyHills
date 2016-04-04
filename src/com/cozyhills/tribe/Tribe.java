package com.cozyhills.tribe;

import com.cozyhills.things.Person;

/**
 * Created by pere5 on 12/03/16.
 */
public class Tribe extends TribeHelper {

    public Tribe(Person person) {
        tribePeople.add(person);
        ruler = person;
        status = assessStatus();
    }

    public void considerTrade() {

    }

    public void considerWar() {

    }

    public void considerMigration() {

    }

    public void considerOccupations() {

    }

    public void considerTribalUnification() {
        for (Tribe otherTribe : getNeighboringTribes()) {
            int otherTribeStatus = otherTribe.getStatus();

        }
    }
}
