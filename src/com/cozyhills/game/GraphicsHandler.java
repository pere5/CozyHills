package com.cozyhills.game;

import com.cozyhills.Const;
import com.cozyhills.cozy.CozyHills;
import com.cozyhills.cozy.StateHolder;
import com.cozyhills.model.VisibleEntity;

import java.awt.Insets;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;

/**
 * Created by pere5 on 21/12/15.
 */
public class GraphicsHandler extends JFrame {
    boolean isRunning = true;
    int fps = 6;
    int windowWidth = Const.WINDOW_WIDTH;
    int windowHeight = Const.WINDOW_HEIGHT;

    BufferedImage backBuffer;
    Insets insets;
    InputHandler input;

    CozyHills cozyHills = new CozyHills();

    int x = 0;

    /**
     * This method starts the game and runs it in a loop
     */
    public void run() {
        initialize();
        int character = 0;
        while(isRunning) {
            long time = System.currentTimeMillis();


            update();
            draw();

            //  delay for each frame  -   time it took for one frame
            time = (1000 / fps) - (System.currentTimeMillis() - time);
            character = ThreadLocalRandom.current().nextInt(1, 3 + 1);
            System.out.print(character == 1 ? "- " : character == 2 ? "+ " : "* ");
            System.out.println(time);

            if (time > 0) {
                try {
                    Thread.sleep(time);
                } catch(Exception e) {
                    System.out.println("Woohah!");
                }
            }
        }
        setVisible(false);
    }

    /**
     * This method will set up everything need for the game to run
     */
    void initialize() {
        setTitle("CozyHills");
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        insets = getInsets();
        setSize(insets.left + windowWidth + insets.right,
                insets.top + windowHeight + insets.bottom);

        backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
        input = new InputHandler(this);
    }

    /**
     * This method will check for input, move things
     * around and check for win conditions, etc
     */
    void update() {
        cozyHills.update();
        /*
        if (input.isKeyDown(KeyEvent.VK_RIGHT)) {
            x += 5;
        }
        if (input.isKeyDown(KeyEvent.VK_LEFT)) {
            x -= 5;
        }*/

    }

    /**
     * This method will draw everything
     */
    void draw() {
        Graphics g = getGraphics();

        Graphics bbg = backBuffer.getGraphics();
        bbg.setColor(Color.WHITE);
        bbg.fillRect(0, 0, windowWidth, windowHeight);

        bbg.setColor(Color.BLACK);

        drawAllObjects(bbg);

        g.drawImage(backBuffer, insets.left, insets.top, this);
    }

    private void drawAllObjects(Graphics bbg) {
        StateHolder stateHolder = StateHolder.instance();
        for (List<VisibleEntity> types: stateHolder.getState()) {
            for (VisibleEntity type: types) {
                bbg.setColor(type.color);
                bbg.fillRect(type.x, type.y, type.size, type.size);
            }
        }
    }
}
