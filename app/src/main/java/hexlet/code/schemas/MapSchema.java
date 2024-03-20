package hexlet.code.schemas;

import java.util.Map;

public class MapSchema {
    private boolean required = false;
    private Integer sizeValue = null;
    private Map<String, BaseSchema<String>> shapeSchemasValue;

    public MapSchema required() {
        required = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        this.sizeValue = size;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> shapeSchemas) {
        this.shapeSchemasValue = shapeSchemas;
        return this;
    }

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

