//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #239245
//Name: #Muhammad Badrul Amin Bin Abdul Razak
package assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Badrul
 */
public class FindLine {

    LinkedList<String> listFileContent;
    public JSONObject json = new JSONObject();
    public JSONArray array = new JSONArray();
    public JSONObject item;
    public int totalLine;
    String task;
    String matrik;

    /*public int command;
    public int kosong;
    public int code;*/
    public JSONObject Hawau(String[] listJavaFile) {
        for (int i = 0; i < listJavaFile.length; i++) {
            int command = 0;
            int kosong = 0;
            int code = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(listJavaFile[i]))) {
                String readLine;
                totalLine = 0;
                while ((readLine = br.readLine()) != null) {
                    if (readLine.contains("//Task:")) {
                        task = readLine.replaceAll("\\s*//Task:\\s*#", "");
                    } else if (readLine.contains("//Matrik:")) {
                        matrik = readLine.replaceAll("\\s*//Matrik:\\s*#", "");
                    }
                    if (readLine.contains("//")) {
                        command++;
                    } else if (readLine.isEmpty()) {
                        kosong++;
                    } else {
                        code++;
                    }
                    totalLine++;
                }
            } catch (IOException e) {
            }
            try {
                item = new JSONObject();
                item.put("Task", task);
                item.put("Matrik", matrik);
                item.put("Command", command);
                item.put("Empty", kosong);
                item.put("Actual", code);
                array.put(item);
                json.put("line", array);
            } catch (JSONException ex) {
            }
        }
        return json;
    }
}
