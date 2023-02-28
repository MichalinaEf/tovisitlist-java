public enum Category {

    CITY("city landscape"), NATURE("nature landscape"), MONUMENT("monument");

    private final String description;

    // Konstruktor
    private Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}