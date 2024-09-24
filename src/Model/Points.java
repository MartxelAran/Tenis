package Model;

public enum Points {
    ZERO(0),
    FIFTEEN(15),
    THIRTY(30),
    FORTY(40),
    DEUCE(-1),
    ADVANTAGE(1),
    WIN(2);

    private int value;

    Points(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private static final Points[] POINTS_VALUES = values();

    public Points nextPoint(Points opponentScore) {
        if (isDeuce(opponentScore)) {
            return DEUCE;
        }
        if (isAdvantage()) {
            return ADVANTAGE;
        }
        if (isWin()) {
            return WIN;
        }

        int ordinal = this.ordinal();
        return POINTS_VALUES[Math.min(ordinal + 1, POINTS_VALUES.length - 1)];
    }

    public boolean isDeuce(Points opponentScore){
        if (this == FORTY && opponentScore == FORTY) {
            return true;
        }
        return false;
    }

    public boolean isAdvantage(){
        if(this == DEUCE){
            return true;
        }
        return false;
    }

    public boolean isWin(){
        if (this == WIN) {
            return true;
        }
        return false;
    }
}
