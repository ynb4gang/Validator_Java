package hexlet.code.schemas;

import java.util.Map;

public class MapSchema {
    private boolean required = false;
    private Integer size = null;
    private Map<String, BaseSchema<String>> shapeSchemas;

    public MapSchema required() {
        required = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        this.size = size;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> shapeSchemas) {
        this.shapeSchemas = shapeSchemas;
        return this;
    }

    public boolean isValid(Map<String, String> map) {
        if (required && map == null) {
            return false;
        }

        if (size != null && map != null && map.size() != size) {
            return false;
        }

        if (shapeSchemas != null && map != null) {
            for (Map.Entry<String, BaseSchema<String>> entry : shapeSchemas.entrySet()) {
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
