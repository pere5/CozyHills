package com.cozyhills.cozy;

import com.cozyhills.Const;
import com.cozyhills.things.VisibleEntity;
import com.cozyhills.things.items.Item;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by pere5 on 30/12/15.
 */
public class Util {

    public static int generateHeight () {
        return Const.WINDOW_HEIGHT / 2 + generateInt();
    }

    public static int generateWidth () {
        return Const.WINDOW_WIDTH / 2 + generateInt();
    }

    private static int generateInt() {
        return 250 - ThreadLocalRandom.current().nextInt(0, 500 + 1);
    }

    private void testClassMembers () {
        for (int i = 0; i < 2000; i++) {
            int boll = generateInt();
            if (boll >= 100 || boll <= -100) {
                System.out.println(boll);
            }
        }
    }

    public static Optional<Class> getCorrespondingResourceFromItemType(Class itemType) {
        try {
            return Optional.of(((Item)itemType.newInstance()).getCorrespondingResourceType());
        } catch (IllegalAccessException | InstantiationException e) {
            return Optional.empty();
        }
    }

    public static void print(double value) {
        System.out.print(value + " ");
    }

    public static void print(long value) {
        System.out.print(value + " ");
    }

    public static void print(int value) {
        System.out.print(value + " ");
    }

    public static void print(String value) {
        System.out.print(value);
    }

    public static void println() {
        System.out.println();
    }

    public static void print(boolean value) {
        System.out.print(value + " ");
    }

    public static void print(VisibleEntity value) {
        System.out.print(value);
    }

    public static void printNotImplemented(String value) {
        System.out.print("NOT IMPLEMENTED: " + value);
    }

    public static void printPerIsStupidMessage(String value) {
        System.out.print("Per is stupid: " + value);
    }

    public static void printActionId(int id) {
        //System.out.print(id);
    }
}
