package managers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ControlsManager implements KeyListener, MouseListener, MouseMotionListener {

    private static ControlsManager cm;

    public static ControlsManager getInstance() {
        if (cm == null) {
            cm = new ControlsManager();
        }

        return cm;
    }

    private boolean[] keys;
    private boolean mousePressed;
    private int mouseX;
    private int mouseY;
    
    public ControlsManager() {
        keys = new boolean[256];
        mousePressed = false;
        mouseX = 0;
        mouseY = 0;
    }

    public boolean getKeyPressed(int keyID) {
        return keys[keyID];
    }

    public boolean getMousePressed() {
        return mousePressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousePressed = false;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}
