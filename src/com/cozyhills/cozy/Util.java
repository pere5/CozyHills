package com.cozyhills.cozy;

import com.cozyhills.things.VisibleEntity;

/**
 * Created by pere5 on 30/12/15.
 */
public class Util {

    private static final boolean MUTE_PRINT = true;

    public static void print(double value) {
        if (!MUTE_PRINT) System.out.print(value + " ");
    }

    public static void print(long value) {
        if (!MUTE_PRINT) System.out.print(value + " ");
    }

    public static void print(int value) {
        if (!MUTE_PRINT) System.out.print(value + " ");
    }

    public static void print(String value) {
        if (!MUTE_PRINT) System.out.print(value);
    }

    public static void println() {
        if (!MUTE_PRINT) System.out.println();
    }

    public static void print(boolean value) {
        if (!MUTE_PRINT) System.out.print(value + " ");
    }

    public static void print(VisibleEntity value) {
        if (!MUTE_PRINT) System.out.print(value);
    }

    public static void printNotImplemented(String value) {
        if (!MUTE_PRINT) System.out.print("NOT IMPLEMENTED: " + value);
    }

    public static void printPerIsStupidMessage(String value) {
        if (!MUTE_PRINT) System.out.print("Per is stupid: " + value);
    }

    public static void printActionId(int id) {
        if (!MUTE_PRINT) System.out.print(id);
    }
}
