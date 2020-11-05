package ass;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class Counter {
    private int counter;

    /**
     * Counter.
     *
     * @param count count
     */
    public Counter(int count) {
        this.counter = count;
    }

    /**
     * Add number to current count.
     *
     * @param number number
     */
    public void increase(int number) {
        this.counter = this.counter + number;
    }

    /**
     * Subtract number from current count.
     *
     * @param number number
     */
    public void decrease(int number) {
        this.counter = this.counter - number;
    }

    /**
     * GetValue.
     *
     * @return counter
     */
    public int getValue() {
        return this.counter;
    }

    /**
     * SetCounter.
     *
     * @param count setCounter
     */
    public void setCounter(int count) {
        this.counter = count;
    }
}
