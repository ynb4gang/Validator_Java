package hexlet.code.schemas;

/**
 * BaseSchema class provides a base for defining validation schemas.
 *
 * @param <T> the type of value to be validated
 */
public abstract class BaseSchema<T> {
    protected boolean required = false;
    /**
     * Sets the schema as required.
     *
     * @return the schema instance
     */
    public BaseSchema<T> required() {
        required = true;
        return this;
    }
    /**
     * Validates the given value according to the schema rules.
     *
     * @param value the value to be validated
     * @return true if the value is valid, otherwise false
     */
    public abstract boolean isValid(T value);
    /**
     * Sets the minimum length for the value.
     *
     * @param minLength the minimum length for the value
     * @return the current schema instance
     */
    public BaseSchema<T> minLength(int minLength) {
        return this;
    }
    /**
     * Checks if the value contains the specified substring.
     *
     * @param substring the substring to check
     * @return the current schema instance
     */
    public BaseSchema<T> contains(String substring) {
        return this;
    }
}
