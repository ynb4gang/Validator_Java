package hexlet.code.schemas;
/**
 * StringSchema class provides methods for defining validation schemas for String values.
 */
public class StringSchema extends BaseSchema<String> {
    private Integer minLengthValue = null;
    private String containsValue = null;
    /**
     * Sets the minimum length constraint for the String.
     *
     * @param minLength the minimum length constraint for the String
     * @return the schema instance
     */
    public StringSchema minLength(int minLength) {
        this.minLengthValue = minLength;
        return this;
    }
    /**
     * Sets the substring constraint for the String.
     *
     * @param contains the substring constraint for the String
     * @return the schema instance
     */
    public StringSchema contains(String contains) {
        this.containsValue = contains;
        return this;
    }
    /**
     * Validates the given String according to the schema rules.
     *
     * @param value the String to be validated
     * @return true if the String is valid, otherwise false
     */
    @Override
    public boolean isValid(String value) {
        if (required && (value == null || value.isEmpty())) {
            return false;
        }

        if (minLengthValue != null && value != null && value.length() < minLengthValue) {
            return false;
        }

        if (containsValue != null && value != null && !value.contains(containsValue)) {
            return false;
        }

        return true;
    }
}

