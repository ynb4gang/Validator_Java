package hexlet.code.schemas;
/**
 * NumberSchema class provides methods for defining validation schemas for Integer values.
 */
public class NumberSchema extends BaseSchema<Integer> {
    private Integer minRangeValue = null;
    private Integer maxRangeValue = null;
    /**
     * Sets the minimum range constraint for the number.
     *
     * @param minRange the minimum range constraint for the number
     * @return the schema instance
     */
    public NumberSchema minRange(int minRange) {
        this.minRangeValue = minRange;
        return this;
    }
    /**
     * Sets the maximum range constraint for the number.
     *
     * @param maxRange the maximum range constraint for the number
     * @return the schema instance
     */
    public NumberSchema maxRange(int maxRange) {
        this.maxRangeValue = maxRange;
        return this;
    }
    /**
     * Sets the constraint for the number to be positive.
     *
     * @return the schema instance
     */
    public NumberSchema positive() {
        return minRange(1);
    }
    /**
     * Sets the range constraints for the number.
     *
     * @param min the minimum range constraint for the number
     * @param max the maximum range constraint for the number
     * @return the schema instance
     */
    public NumberSchema range(int min, int max) {
        minRange(min);
        maxRange(max);
        return this;
    }
    /**
     * Validates the given number according to the schema rules.
     *
     * @param value the number to be validated
     * @return true if the number is valid, otherwise false
     */
    @Override
    public boolean isValid(Integer value) {
        if (required && value == null) {
            return false;
        }

        if (minRangeValue != null && value != null && value < minRangeValue) {
            return false;
        }

        if (maxRangeValue != null && value != null && value > maxRangeValue) {
            return false;
        }

        return true;
    }
}
