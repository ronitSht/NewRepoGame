package menu;

import animation.Animation;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @param <T> Menu
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public interface Menu<T> extends Animation {

    /**
     * addSelection.
     *
     * @param key       key
     * @param message   message
     * @param returnVal returnVal
     */
    void addSelection(String key, String message, T returnVal);

    /**
     * getStatus.
     *
     * @return T
     */
    T getStatus();

    /**
     * addSubMenu.
     *
     * @param key     key
     * @param message message
     * @param subMenu subMenu
     */
    void addSubMenu(String key, String message, Menu<T> subMenu);
}
