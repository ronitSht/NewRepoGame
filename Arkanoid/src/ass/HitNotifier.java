package ass;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     *
     * @param hl hl
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl hl
     */
    void removeHitListener(HitListener hl);
}
