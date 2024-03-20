package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    private Integer minLengthValue = null;
    private String containsValue = null;

    public StringSchema minLength(int minLength) {
        this.minLengthValue = minLength;
        return this;
    }

    public StringSchema contains(String contains) {
        this.containsValue = contains;
        return this;
    }

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

