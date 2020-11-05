package menu;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class LevelForSet {
    private String key;
    private String path;
    private String name;

    /**
     * @param keyStr  keyStr
     * @param nameStr nameStr
     * @param pathStr pathStr
     */
    public LevelForSet(String keyStr, String nameStr, String pathStr) {
        this.key = keyStr;
        this.name = nameStr;
        this.path = pathStr;
    }

    /**
     * getPath.
     *
     * @return path
     */
    public String getPath() {
        return this.path;
    }

    /**
     * getKey.
     *
     * @return key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * getName.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }
}
