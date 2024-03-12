class StringSchema {
    private boolean required = false;
    private Integer minLength = null;
    private String contains = null;

    public void required() {
        required = true;
    }

    public StringSchema minLength(int minLength) {
        this.minLength = minLength;
        return this;
    }

    public StringSchema contains(String contains) {
        this.contains = contains;
        return this;
    }

    public boolean isValid(String data) {
        if (required && (data == null || data.isEmpty())) {
            return false;
        }

        if (minLength != null && data.length() < minLength) {
            return false;
        }

        return contains == null || data.contains(contains);
    }
}
