package menu;

import animation.AnimationRunner;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @param <T> MenuAnimation
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class MenuAnimation<T> implements Menu<T> {
    private AnimationRunner animation;
    private String str;
    private KeyboardSensor keyboard;
    private T t;
    private ArrayList<String> menuNames;
    private ArrayList<String> menuKeys;
    private ArrayList<T> menuValuesToReturn;
    private ArrayList<MenuSelection<T>> selectionsList;
    private boolean stop;

    /**
     * MenuAnimation.
     *
     * @param animationRunner animationRunner
     * @param string          string
     * @param keyboardSensor  keyboardSensor
     */
    public MenuAnimation(AnimationRunner animationRunner, String string, KeyboardSensor keyboardSensor) {
        this.animation = animationRunner;
        this.str = string;
        this.keyboard = keyboardSensor;
        this.menuNames = new ArrayList<>();
        this.menuKeys = new ArrayList<>();
        this.menuValuesToReturn = new ArrayList<>();
        this.selectionsList = new ArrayList<>();
    }

    /**
     * doOneFrame.
     *
     * @param drawSurface drawSurface
     * @param dt          dt
     */
    public void doOneFrame(DrawSurface drawSurface, double dt) {

        drawSurface.setColor(new Color(131, 34, 117));
        drawSurface.fillRectangle(0, 0, 800, 600);
        for (int i = 0; i < this.selectionsList.size(); i++) {
            int[] x = {0, 520, 470, 0};
            int[] y = {200 + 70 * i, 200 + 70 * i, 260 + 70 * i, 260 + 70 * i};
            drawSurface.setColor(new Color(153, 153, 153));
            drawSurface.setColor(new Color(0, 29, 72));
            drawSurface.setColor(Color.WHITE);
            drawSurface.drawText(140, 250 + i * 70, this.selectionsList.get(i).getStr(), 50);
            drawSurface.setColor(new Color(255, 235, 37));
            drawSurface.drawText(140, 150, "Arkanoid", 70);
        }
        this.t = null;
    }

    /**
     * shouldStop.
     *
     * @return stop
     */
    public boolean shouldStop() {
        for (MenuSelection<T> selection : selectionsList) {
            if (this.keyboard.isPressed(selection.getKeyStr())) {
                this.stop = true;
            }
        }
        return this.stop;
    }

    /**
     * addSelection.
     *
     * @param key       key
     * @param message   message
     * @param returnVal returnVal
     */
    public void addSelection(String key, String message, T returnVal) {
        this.selectionsList.add(new MenuSelection<>(key, message, returnVal));
    }

    /**
     * getStatus.
     *
     * @return t
     */
    public T getStatus() {
        for (MenuSelection<T> listSelection : selectionsList) {
            if (this.keyboard.isPressed(listSelection.getKeyStr())) {
                if (listSelection.getSubMenu() != null) {
                    this.animation.run(listSelection.getSubMenu());
                    this.t = listSelection.getSubMenu().getStatus();
                    break;
                } else {
                    this.t = listSelection.getVal();
                    break;
                }
            }
        }
        this.stop = false;
        return this.t;
    }

    /**
     * addSubMenu.
     *
     * @param key     key
     * @param message message
     * @param subMenu subMenu
     */
    public void addSubMenu(String key, String message, Menu<T> subMenu) {
        this.selectionsList.add(new MenuSelection<>(key, message, subMenu));

    }
}
