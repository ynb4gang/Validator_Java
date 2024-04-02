package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private final Map<String, Predicate<T>> validityChecks;

    protected BaseSchema() {
        this.validityChecks = new HashMap<>();
    }

    public final void addCheck(String typeValidation, Predicate<T> method) {
        validityChecks.put(typeValidation, method);
    }

    public final boolean isValid(T object) {
        return validityChecks.values()
                .stream()
                .allMatch(check -> check.test(object));
    }
}
