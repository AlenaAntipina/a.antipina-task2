package main;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtils {
    public static String browser;
    public static String url;
    public static int wait_time;
    public static int load_page_time;
    public static int wait_visibility;

    public static void readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/config.json");

        Object obj = jsonParser.parse(reader);
        JSONObject jo = (JSONObject) obj;

        browser = (String) jo.get("browser");
        url = (String) jo.get("url");
        wait_time = Integer.parseInt((String) jo.get("wait_time"));
        load_page_time = Integer.parseInt((String) jo.get("load_page_time"));
        wait_visibility = Integer.parseInt((String) jo.get("wait_visibility"));
    }
}
