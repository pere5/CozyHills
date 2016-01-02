package com.cozyhills;

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
        return 100 - ThreadLocalRandom.current().nextInt(0, 200 + 1);
    }

    private void testClassMembers () {
        for (int i = 0; i < 2000; i++) {
            int boll = generateInt();
            if (boll >= 100 || boll <= -100) {
                System.out.println(boll);
            }
        }
    }
}
