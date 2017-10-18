//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #239245
//Name: #Muhammad Badrul Amin Bin Abdul Razak
package assignment2;

import org.json.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Badrul
 */
public class OpenJava {

    LinkedList<String> listFileContent;
    public String semester;
    public String course;
    public String group;
    public String task;
    public String matrik;
    public String name;
    public JSONObject json = new JSONObject();
    public JSONArray array = new JSONArray();
    public JSONObject item;

    public JSONObject info(String[] listJavaFile) {
        for (int i = 0; i < listJavaFile.length; i++) {
            try (BufferedReader br = new BufferedReader(new FileReader(listJavaFile[i]))) {
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    if (readLine.contains("//Semester:")) {
                        //System.out.println(listJavaFile[i]);
                        semester = readLine.replaceAll("\\s*//Semester:\\s*#", "");
                    } else if (readLine.contains("//Course:")) {
                        course = readLine.replaceAll("\\s*//Course:\\s*#", "");
                    } else if (readLine.contains("//Task:")) {
                        task = readLine.replaceAll("\\s*//Task:\\s*#", "");
                    } else if (readLine.contains("//Matrik:")) {
                        matrik = readLine.replaceAll("\\s*//Matrik:\\s*#", "");
                    } else if (readLine.contains("//Name:")) {
                        name = readLine.replaceAll("\\s*//Name:\\s*#", "");
                    }
                }
            } catch (IOException e) {
            }
            try {
                item = new JSONObject();
                item.put("File Name", listJavaFile[i]);
                item.put("Semester", semester);
                item.put("Course", course);
                item.put("Task", task);
                item.put("Matrik", matrik);
                item.put("Name", name);
                array.put(item);

                json.put("information", array);
            } catch (JSONException ex) {
            }
        }
        return json;
    }
}
