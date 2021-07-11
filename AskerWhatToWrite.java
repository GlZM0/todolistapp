package todolist;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AskerWhatToWrite {

    //First commit on a new branch - Write
    //Next commit on a Write branch

    @SuppressWarnings("unchecked")
    public void whatYouWantToWrite() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Write the date of the day you want to write (dd-MM-yyyy)");
        String dayToWriteAnswer = sc1.nextLine();

        JSONParser jsonParser = new JSONParser();

        try(FileReader reader = new FileReader(dayToWriteAnswer + ".json")) {
            Object obj = jsonParser.parse(reader);

            JSONArray taskList = (JSONArray) obj;
            System.out.println(taskList);

            taskList.forEach(task -> parseTaskListObject((JSONObject) task));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseTaskListObject(JSONObject taskL) {
        JSONObject taskNameObject = (JSONObject) taskL.get("date");

        String tasks = (String) taskNameObject.get("tasks");
        System.out.println(tasks);
    }
}
