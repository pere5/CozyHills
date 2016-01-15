package com.cozyhills.cozy;

import com.cozyhills.Const;

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

    public static int generateInt () {
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
}
