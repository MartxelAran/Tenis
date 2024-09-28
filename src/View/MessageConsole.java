package View;

public enum MessageConsole {

    TITLE(":::::: TENIS MATCH ::::::"),
    OPTION_1_CREATE_GAME("1. Create game"),
    OPNTION_2_CREATE_REFEREE("2. Create referee"),
    OPTION_3_CREATE_PLAYER("3. Create player"),
    OPTION_4_READ_PLAYER("4. Read player"),
    OPTION_5_HISTORY("5. View history"),
    OPTION_6_EXIT("6. Exit");

    private final String message;

    MessageConsole(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }


}