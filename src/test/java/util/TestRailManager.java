package util;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static constants.LoginConstants.SCREENSHOT_FILE_NAME;

public class TestRailManager {
    public static String TEST_RUN_ID = "2";
    public static String TEST_RAIL_USER_NAME = "rowdra9@gmail.com";
    public static String TEST_RAIL_PASSWORD = System.getenv("TR_PASS");
    public static String TEST_RAIL_ENGINE_URL = "https://ali85.testrail.io";
    public static int TEST_CASE_PASS_STATUS = 1;
    public static int TEST_CASE_FAIL_STATUS = 5;

    private static APIClient getClient() {
        APIClient client = new APIClient(TEST_RAIL_ENGINE_URL);
        client.setUser(TEST_RAIL_USER_NAME);
        client.setPassword(TEST_RAIL_PASSWORD);
        return client;
    }

    public static void addResultsForTestCase(String testCaseId,
                                             int status,
                                             String resultText) {
        APIClient client = getClient();

        Map<String, Object> data = new HashMap<>();
        data.put("status_id", status);
        data.put("comment", "Test execution completed. " + resultText);

        try {
            JSONObject response = (JSONObject) client
                    .sendPost(String.format("add_result_for_case/%s/%s", TEST_RUN_ID, testCaseId), data);
            String resultId = response.get("id").toString();

            File screenshotFile = new File(SCREENSHOT_FILE_NAME);
            if (screenshotFile.exists()) {
                client.sendPost(String.format("add_attachment_to_result/%s", resultId), SCREENSHOT_FILE_NAME);
                System.out.println("Screenshot attached successfully to result ID: " + resultId);
            }

        } catch (IOException | APIException e) {
            throw new RuntimeException("Failed to update TestRail results or attach screenshot", e);
        }
    }
}
