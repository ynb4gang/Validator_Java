package hexlet.code.schemas;

import java.util.Map;
/**
 * MapSchema class provides methods for defining validation schemas for Map objects.
 */
public class MapSchema {
    private boolean required = false;
    private Integer sizeValue = null;
    private Map<String, BaseSchema<String>> shapeSchemasValue;
    /**
     * Sets the schema as required.
     *
     * @return the schema instance
     */
    public MapSchema required() {
        required = true;
        return this;
    }
    /**
     * Sets the expected size of the Map.
     *
     * @param size the expected size of the Map
     * @return the schema instance
     */
    public MapSchema sizeof(int size) {
        this.sizeValue = size;
        return this;
    }
    /**
     * Sets the shape schema for the Map.
     *
     * @param shapeSchemas the shape schema for the Map
     * @return the schema instance
     */
    public MapSchema shape(Map<String, BaseSchema<String>> shapeSchemas) {
        this.shapeSchemasValue = shapeSchemas;
        return this;
    }
    /**
     * Validates the given Map according to the schema rules.
     *
     * @param map the Map to be validated
     * @return true if the Map is valid, otherwise false
     */
    public boolean isValid(Map<String, String> map) {
        if (required && map == null) {
            return false;
        }

        if (sizeValue != null && map != null && map.size() != sizeValue) {
            return false;
        }

        if (shapeSchemasValue != null && map != null) {
            for (Map.Entry<String, BaseSchema<String>> entry : shapeSchemasValue.entrySet()) {
                String key = entry.getKey();
                BaseSchema<String> schema = entry.getValue();
                if (!map.containsKey(key) || !schema.isValid(map.get(key))) {
                    return false;
                }
            }
        }

        return true;
    }
}

