package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    private Integer minRangeValue = null;
    private Integer maxRangeValue = null;

    public NumberSchema minRange(int minRange) {
        this.minRangeValue = minRange;
        return this;
    }

    public NumberSchema maxRange(int maxRange) {
        this.maxRangeValue = maxRange;
        return this;
    }

    public NumberSchema positive() {
        return minRange(1);
    }

    public NumberSchema range(int min, int max) {
        minRange(min);
        maxRange(max);
        return this;
    }

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
