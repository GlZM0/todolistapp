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

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        JSONObject dateJsonDetails = new JSONObject();
        dateJsonDetails.put("date", dateFormat.format(date));

        JSONObject dateJsonObject1 = new JSONObject();
        dateJsonObject1.put("data", dateJsonDetails);

        JSONArray itemsJsonArray = new JSONArray();

        for(int i = 1; i <= howManyItemsToAdd; i++) {
            Scanner itemtoadd = new Scanner(System.in);
            System.out.println(i+". ");
            String itemtoaddanswer = itemtoadd.nextLine();
            itemsToDoList.add(itemtoaddanswer);
            itemsJsonArray.add(itemtoaddanswer);
        }

        JSONObject itemsJsonObject2 = new JSONObject();
        itemsJsonObject2.put("data", itemsJsonArray);

        JSONArray dataJsonList = new JSONArray();
        dataJsonList.add(dateJsonObject1);
        dataJsonList.add(itemsJsonObject2);

        try {
            FileWriter fileWriter = new FileWriter(dateFormat.format(date) + ".json");
            fileWriter.write(dataJsonList.toJSONString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
