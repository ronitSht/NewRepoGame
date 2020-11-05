package menu;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @param <T> Task
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public interface Task<T> {
    /**
     * run.
     *
     * @return T
     */
    T run();
}
