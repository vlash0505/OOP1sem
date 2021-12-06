package mytimeorganizer.controllers;

public enum RegularExpression {
    EMAIL("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"),
    USERNAME("^[A-Za-z][A-Za-z0-9_]{7,29}$"),
    PASSWORD("^[A-Za-z0-9][A-Za-z0-9_]{7,29}$");

    private final String regularExpression;

    RegularExpression(String regularExpression) {
        this.regularExpression = regularExpression;
    }

    public String getRegularExpression() {
        return regularExpression;
    }
}
