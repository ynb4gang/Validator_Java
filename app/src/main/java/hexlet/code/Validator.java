package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
/**
 * Validator class provides methods for defining validation schemas.
 */
public class Validator {
    /**
     * Creates a new StringSchema instance.
     *
     * @return a new StringSchema instance
     */
    public StringSchema string() {
        return new StringSchema();
    }
    /**
     * Creates a new NumberSchema instance.
     *
     * @return a new NumberSchema instance
     */
    public NumberSchema number() {
        return new NumberSchema();
    }
    /**
     * Creates a new MapSchema instance.
     *
     * @return a new MapSchema instance
     */
    public MapSchema map() {
        return new MapSchema();
    }
}
