package Model;

public enum Points {
    ZERO(0),
    FIFTEEN(1),
    THIRTY(2),
    FORTY(3),
    ADVANTAGE(4);

    private final int value;

    Points(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getPoints() {
        return switch (this) {
            case FIFTEEN -> "15";
            case THIRTY -> "30";
            case FORTY -> "40";
            case ADVANTAGE -> "AD";
            default -> "0";
        };
    }

    public static Points getPoints(int value) {
        return switch (value) {
            case 0 -> ZERO;
            case 1 -> FIFTEEN;
            case 2 -> THIRTY;
            case 3 -> FORTY;
            case 4 -> ADVANTAGE;
            default -> null;
        };
    }
}
