import java.io.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonDemo {
    public static void main(String[] args)
            throws IOException, ParseException {

        JSONParser parser = new JSONParser();

        // JSON 파일 읽기
        Reader reader = new FileReader("C:\\mySrc\\intelli\\springDemo\\springDemo\\src\\main\\java\\test.json");
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        String name = (String) jsonObject.get("name");
        String id = (String) jsonObject.get("id");
        String price = (String) jsonObject.get("price");

        JSONObject jo = new JSONObject();
        jo.put("name","sangyeon");
        jo.put("id", "msy12");
        jo.put("price", "1000");

        String jsonStr = jo.toString();
        File jsonFile = new File("C:\\mySrc\\intelli\\springDemo\\springDemo\\src\\main\\java\\test.json");

        writeStringToFile(jsonStr,jsonFile);

        System.out.println(name);  // apple
        System.out.println(id);  // 1
        System.out.println(price);  // 1000

    }
    //json 쓰기
    public static void writeStringToFile(String str, File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(str);
        writer.close();
    }

}