package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema<T> extends BaseSchema<T> {
    public StringSchema() {
        Predicate<T> instanceofString = str -> str == null || str instanceof String;
        addCheck("instanceof", instanceofString);
    }

    public StringSchema required() {
        Predicate<T> requiredString = str -> (str != null && !str.equals(""));
        addCheck("required", requiredString);
        return this;
    }

    public StringSchema minLength(Integer minLength) {
        Predicate<T> minLengthString = str -> str != null && ((String) str).length() >= minLength;
        addCheck("minLength", minLengthString);
        return this;
    }

    public StringSchema contains(String substring) {
        Predicate<T> containsString = str -> substring != null && str != null
                && str.toString().contains(substring);
        addCheck("contains", containsString);
        return this;
    }
}
