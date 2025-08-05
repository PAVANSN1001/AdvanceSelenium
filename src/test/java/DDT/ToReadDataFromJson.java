package DDT;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ToReadDataFromJson {

	public static void main(String[] args) throws IOException, ParseException {
    FileReader fir= new FileReader(".\\src\\test\\resources\\Commondata.json");
    JSONParser parser= new JSONParser();
    //convert physical file into java object
    Object javaobj = parser.parse(fir);
    //type casting
    JSONObject obj=(JSONObject) javaobj;
    //Reading data
    String BROWSER = obj.get("Browser").toString();
    System.out.println(BROWSER);
	}

}
