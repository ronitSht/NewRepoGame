package menu;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @param <T> MenuSelection
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class MenuSelection<T> {
    private String keyStr;
    private String string;
    private T t;
    private Menu<T> subMenu;

    /**
     * @param key       key
     * @param message   message
     * @param returnVal returnVal
     */
    public MenuSelection(String key, String message, T returnVal) {
        this.keyStr = key;
        this.string = message;
        this.t = returnVal;
    }

    /**
     * MenuSelection.
     *
     * @param key     key
     * @param message message
     * @param subMenu subMenu
     */
    public MenuSelection(String key, String message, Menu<T> subMenu) {
        this.keyStr = key;
        this.string = message;
        this.subMenu = subMenu;
    }

    /**
     * getKeyStr.
     *
     * @return keyStr
     */
    public String getKeyStr() {
        return this.keyStr;
    }

    /**
     * getStr.
     *
     * @return string
     */
    public String getStr() {
        return this.string;
    }

    /**
     * getSubMenu.
     *
     * @return subMenu
     */
    public Menu<T> getSubMenu() {
        return this.subMenu;
    }

    /**
     * getVal.
     *
     * @return t
     */
    public T getVal() {
        return this.t;
    }
}

