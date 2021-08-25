package todolist;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AddToDoItem {
    public void addingItemsToDo(int howManyItemsToAdd) {

        ArrayList<String> itemsToDoList = new ArrayList<>(howManyItemsToAdd);

        JSONArray dataJsonList = new JSONArray();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        JSONObject dateJsonDetails = new JSONObject();
        dateJsonDetails.put("date", dateFormat.format(date));

        dataJsonList.add(dateJsonDetails);

        JSONArray itemsJsonDetails = new JSONArray();

        for(int i = 1; i <= howManyItemsToAdd; i++) {
            Scanner itemtoadd = new Scanner(System.in);
            System.out.println(i+". ");
            String itemtoaddanswer = itemtoadd.nextLine();
            itemsToDoList.add(itemtoaddanswer);
            itemsJsonDetails.add(itemtoaddanswer);
        }

        JSONObject ArrayJsonObject = new JSONObject();
        ArrayJsonObject.put("items", itemsJsonDetails);

        dataJsonList.add(ArrayJsonObject);

        try {
            FileWriter fileWriter = new FileWriter(dateFormat.format(date) + ".json");
            fileWriter.write(dataJsonList.toJSONString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
