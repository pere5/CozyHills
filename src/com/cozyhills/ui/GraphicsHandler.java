package com.cozyhills.ui;

import com.cozyhills.Const;
import com.cozyhills.cozy.CozyHills;
import com.cozyhills.cozy.StateHolder;
import com.cozyhills.cozy.Util;
import com.cozyhills.things.VisibleEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by pere5 on 21/12/15.
 */
public class GraphicsHandler extends JFrame {
    private boolean isRunning = true;
    private int windowWidth = Const.WINDOW_WIDTH;
    private int windowHeight = Const.WINDOW_HEIGHT;

    private BufferedImage backBuffer;
    private Insets insets;
    private InputHandler input;

    private CozyHills cozyHills = new CozyHills();

    private boolean pause;
    int lastFramesPerSecond = 0;

    /**
     * This method starts the game and runs it in a loop
     */
    public GraphicsHandler() {
        initialize();
        int intendedFps = 8;
        int framesPerSecond = 0;
        long startTime = System.currentTimeMillis();

        while(isRunning) {
            long timeBeforeFrame = System.currentTimeMillis();

            update();
            draw();

            //  delay for each frame  -   time it took for one frame
            long time = (1000 / intendedFps) - (System.currentTimeMillis() - timeBeforeFrame);
            if (time > 0) {
                try {
                    Thread.sleep(time);
                } catch(Exception e) {
                    System.out.println("Woohah!");
                }
            }
            if (!pause) {
                long currentTime = System.currentTimeMillis();
                framesPerSecond++;
                if (currentTime - startTime > 1000) {
                    startTime = currentTime;
                    lastFramesPerSecond = framesPerSecond;
                    framesPerSecond = 0;
                }
                System.out.println();
            }
        }
        setVisible(false);
    }

    /**
     * This method will set up everything need for the game to run
     */
    private void initialize() {
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
        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                printValuesOfPoint(e.getPoint());
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        this.getContentPane().addMouseListener(mouseListener);
    }

    private void printValuesOfPoint(Point point) {
        outerLoop:
        for (Set<? extends VisibleEntity> visibleEntities: StateHolder.getState().values()) {
            for (VisibleEntity visibleEntity: visibleEntities) {
                double veLeftBound = (visibleEntity.xy[0]);
                double veRightBound = (visibleEntity.xy[0] + visibleEntity.size + 2);
                double veTopBound = (visibleEntity.xy[1]);
                double veBottomBound = (visibleEntity.xy[1] + visibleEntity.size + 2);
                double pX = point.getX();
                double pY = point.getY();
                if (pX > veLeftBound && pX < veRightBound && pY > veTopBound && pY < veBottomBound) {
                    Util.print(visibleEntity);
                    Util.println();
                    break outerLoop;
                }
            }
        }
    }

    /**
     * This method will check for input, move things
     * around and check for win conditions, etc
     */
    private void update() {
        boolean spaceHasBeenPressed = input.keyHasBeenPressed(KeyEvent.VK_SPACE);
        if (spaceHasBeenPressed) {
            pause = !pause;
        }

        if (!pause) {
            cozyHills.update();
        }
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
    private void draw() {
        Graphics g = getGraphics();

        Graphics bbg = backBuffer.getGraphics();
        bbg.setColor(Color.WHITE);
        bbg.fillRect(0, 0, windowWidth, windowHeight);

        bbg.setColor(Color.BLACK);

        drawAllObjects(bbg);

        bbg.setColor(Color.BLACK);
        bbg.drawString("FPS: " + lastFramesPerSecond, Const.WINDOW_WIDTH - 60, Const.WINDOW_HEIGHT - 20);

        g.drawImage(backBuffer, insets.left, insets.top, this);
    }

    private void drawAllObjects(Graphics bbg) {
        for (Set<? extends VisibleEntity> visibleEntities: StateHolder.getState().values()) {
            for (VisibleEntity visibleEntity: visibleEntities) {
                bbg.setColor(visibleEntity.color);
                if (visibleEntity.SHAPE.equals(Const.SHAPES.RECT)) {
                    bbg.fillRect((int)visibleEntity.xy[0], (int)visibleEntity.xy[1], visibleEntity.size, visibleEntity.size);
                } else {
                    bbg.fillOval((int)visibleEntity.xy[0], (int)visibleEntity.xy[1], visibleEntity.size, visibleEntity.size);
                }
            }
        }
    }
}
