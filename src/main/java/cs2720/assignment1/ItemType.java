package cs2720.assignment1;

/**
 * A wrapper class that allows for different values to be stored within a list.
 */
public class ItemType {
    // Variable for the value of the Item.
    private int value;

    /**
     * This function compares two ItemTypes and their values.
     *
     * @param item the item being compared to the current item.
     * @return the interger comparison value of the values of the current ItemType and
     * {@code item}.
     */
    public int compareTo(ItemType item) {
        if (this.value < item.value) {
            return -1;
        } else if (this.value > item.value) {
            return 1;
        }
        return 0;
    } // compareTo

    /**
     * Returns the value instance variable {@code value}.
     *
     * @return {@code value}.
     */
    public int getValue() {
        return this.value;
    } // getValue

    /**
     * Initializes the data member by variable {@code num}.
     *
     * @param num value to be initialized.
     */
    public void initialize(int num) {
        this.value = num;
    } // initialize

    /**
     * Checks if given number is equal to current value.
     *
     * @param num the number to compare to.
     * @return if {@code num} and {@code value} are the same number.
     */
    public boolean equals(int num) {
        if (num == this.value) {
            return true;
        }
        return false;
    } // equals
} // ItemType
