package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    protected boolean required = false;

    public BaseSchema<T> required() {
        required = true;
        return this;
    }

    public abstract boolean isValid(T value);

    public BaseSchema<T> minLength(int minLength) {
        return this;
    }

    public BaseSchema<T> contains(String substring) {
        return this;
    }
}
