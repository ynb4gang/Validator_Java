package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema<R, T> extends BaseSchema<T> {

    public MapSchema<R, T> required() {
        Predicate<T> requiredMap = map -> map instanceof Map<?, ?>;
        addCheck("required", requiredMap);
        return this;
    }

    public MapSchema<R, T> sizeof(Integer size) {
        Predicate<T> sizeofMap = map -> map == null || map instanceof Map && ((Map) map).size() == size;
        addCheck("sizeof", sizeofMap);
        return this;
    }

    public MapSchema<R, T> shape(Map<String, BaseSchema<T>> schemas) {
        Predicate<T> shapeMap = map -> map == null || map instanceof Map && schemas.entrySet().stream()
                .allMatch(schema -> schema.getValue()
                        .isValid((T) ((Map<String, ?>) map).get(schema.getKey())));
        addCheck("shape", shapeMap);
        return this;
    }
}
