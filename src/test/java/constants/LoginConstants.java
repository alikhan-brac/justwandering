package constants;

import java.util.UUID;

public class LoginConstants {
    public static final String BASE_URL = "http://uitestingplayground.com/";
    public static final int MAX_WAIT = 10;
    public static final String USER_ID = UUID.randomUUID().toString();
    public static final String EXPECTED_TEXT = String.format("Welcome, %s!", USER_ID);
    public static final String PASSWORD = "pwd";
    public static final String INVALID_PASSWORD = "invalid";
    public static final String EXPECTED_TEXT_FOR_INVALID_CREDENTIAL = "Invalid username/password";
    public static final String SCREENSHOT_FILE_NAME = "src/test/resources/screenshot.jpeg";
}
