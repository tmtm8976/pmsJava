package pharmacy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class ReadJSONExample 
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) 
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("Pharma.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
             
            //Iterate over employee array
            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        
    }
 
    private static void parseEmployeeObject(JSONObject medic) 
    {
        //Get employee object within list
        JSONObject medicObject = (JSONObject) medic.get("medic");
         
        //Get employee first name
        String type = (String) medicObject.get("Type");    
        System.out.println(type);
         
        //Get employee last name
        String price = (String) medicObject.get("Price");  
        System.out.println(price);
         
        //Get employee website name
        long quantity = (long) medicObject.get("Quantity");    
        System.out.println(quantity);
    }
}
