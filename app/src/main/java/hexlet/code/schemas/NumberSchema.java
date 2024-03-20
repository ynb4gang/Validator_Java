package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    private Integer minRange = null;
    private Integer maxRange = null;

    public NumberSchema minRange(int minRange) {
        this.minRange = minRange;
        return this;
    }

    public NumberSchema maxRange(int maxRange) {
        this.maxRange = maxRange;
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

        if (minRange != null && value != null && value < minRange) {
            return false;
        }

        if (maxRange != null && value != null && value > maxRange) {
            return false;
        }

        return true;
    }
}
