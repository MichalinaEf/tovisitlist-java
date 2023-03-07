package app;

import exception.NoSuchOptionException;

import java.util.InputMismatchException;

public enum Option {

    EXIT (0, " - to exit the program"),
    ADD_CITY(1," - to add new city to your ToVisitList"),
    ADD_MONUMENT(2," - to add new monument to your ToVisitList"),
    ADD_NATURAL_SPOT (3, " - to add new natural spot to your ToVisitList"),
    PRINT_CITIES_ON_YOUR_TO_VISIT_LIST (4, " - to see cities on your ToVisitList and plan new journey :)"),
    PRINT_MONUMENTS_ON_YOUR_TO_VISIT_LIST (5, " - to see monuments on your ToVisitList and plan new journey :)"),
    PRINT_NATURAL_SPOTS_ON_YOUR_TO_VISIT_LIST (6, " - to see natural spots on your ToVisitList and plan new journey :)"),
    PRINT_TOVISITLIST(7, " - to see your ToVisitList");

    private int value;
    private String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return value+description;
    }

    static Option createFromInt(int option) throws NoSuchOptionException {
        try {
            return Option.values()[option];
        } catch (InputMismatchException e){
            throw new NoSuchOptionException("There is no option: " + option);
        }
    }
}
