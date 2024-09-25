package Model;

public enum Points {
    ZERO(0),
    FIFTEEN(1),
    THIRTY(2),
    FORTY(3),
    ADVANTAGE(4);

    private int value;

    Points(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getPoints() {
        switch (this) {
            case ZERO: return 0;
            case FIFTEEN: return 15;
            case THIRTY: return 30;
            case FORTY: return 40;
            case ADVANTAGE: return 50;
            default: return 0;
        }
    }

    public static Points getPoints(int value) {
        switch (value) {
            case 0: return ZERO;
            case 1: return FIFTEEN;
            case 2: return THIRTY;
            case 3: return FORTY;
            case 4: return ADVANTAGE;
            default: return null;
        }
    }
}
