package pages.enums;

public enum ColorList {

    ORANGE("Orange"),
    BLUE("Blue"),
    RED("Red"),
    WHITE("White"),
    BLACK("Black"),;

    private final String name;

    private ColorList(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
