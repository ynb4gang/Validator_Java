package schemas;
public class StringSchema extends BaseSchema<String> {
    private Integer minLength = null;
    private String contains = null;

    public StringSchema minLength(int minLength) {
        this.minLength = minLength;
        return this;
    }

    public StringSchema contains(String contains) {
        this.contains = contains;
        return this;
    }

    @Override
    public boolean isValid(String value) {
        if (required && (value == null || value.isEmpty())) {
            return false;
        }

        if (minLength != null && value != null && value.length() < minLength) {
            return false;
        }

        if (contains != null && value != null && !value.contains(contains)) {
            return false;
        }

        return true;
    }
}
