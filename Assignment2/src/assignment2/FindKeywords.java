//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment1
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
public class FindKeywords {

    LinkedList<String> listFileContent;
    public JSONObject json = new JSONObject();
    public JSONArray array = new JSONArray();
    public JSONObject item;
    String task;
    String matrik;
    String ni;
    String keyword[] = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "continue",
        "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for",
        "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package",
        "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized",
        "this", "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "null",
        "false", "const", "goto"};

    public JSONObject CountKeyword(String[] listJavaFile) {
        for (int i = 0; i < listJavaFile.length; i++) {
            int kira[] = new int[keyword.length];
            try (BufferedReader br = new BufferedReader(new FileReader(listJavaFile[i]))) {
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    if (readLine.contains("//Task:")) {
                        task = readLine.replaceAll("\\s*//Task:\\s*#", "");
                    } else if (readLine.contains("//Matrik:")) {
                        matrik = readLine.replaceAll("\\s*//Matrik:\\s*#", "");
                    }
                    for (int j = 0; j < keyword.length; j++) {
                        if (readLine.contains(keyword[j])) {
                            kira[j] = kira[j] + 1;
                        }
                    }
                }
            } catch (IOException e) {
            }
            try {
                item = new JSONObject();
                item.put("Task", task);
                item.put("Matrik", matrik);
                for (int l = 0; l < keyword.length; l++) {
                    item.put(keyword[l], kira[l]);
                }
                array.put(item);
                json.put("listKeyword", array);
            } catch (JSONException ex) {
            }
        }
        return json;
    }
}
