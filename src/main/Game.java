package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import managers.ControlsManager;
import managers.EntityManager;
import managers.WorldManager;

import utils.Constants;

public class Game implements Runnable {

    private final long DELTA_TIME = 10;

    private Thread thread;
    private boolean running;

    private Display display;
    private BufferStrategy bs;
    private Graphics g;

    private WorldManager wm;
    private EntityManager em;

    public Game() {
        display = new Display();
        wm = new WorldManager();
        em = new EntityManager();
        running = false;
    }

    private void init() {
        display.initialize();
        display.getFrame().addKeyListener(ControlsManager.getInstance());
        display.getCanvas().addMouseListener(ControlsManager.getInstance());
        display.getCanvas().addMouseMotionListener(ControlsManager.getInstance());
        display.getCanvas().createBufferStrategy(Constants.NUMBER_OF_BUFFERS);
        bs = display.getCanvas().getBufferStrategy();
    }

    private void update() {
       wm.update();
       em.update();
    }

    private void render() {
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        wm.render(g);
        em.render(g);
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();
        long target = System.currentTimeMillis() + DELTA_TIME;
        while (running) {
            if (System.currentTimeMillis() - target > 0) {
                update();
                render();
                target = System.currentTimeMillis() + DELTA_TIME;
            }
        }

        stop();
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
