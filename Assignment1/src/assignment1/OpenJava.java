//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment1
//Matrik: #239245
//Name: #Muhammad Badrul Amin Bin Abdul Razak
package assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Badrul
 */
public class OpenJava {

    File file;
    String fileContent[][];
    LinkedList<String> listFileContent;
    public int noIssue;
    public int totalJava;

    public void Hawau(String[] listJavaFile) {
        for (int i = 0; i < listJavaFile.length; i++) {
            try (BufferedReader br = new BufferedReader(new FileReader(listJavaFile[i]))) {
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    if (readLine.contains("public static void main")) {
                        noIssue++;
                    }
                }
            } catch (IOException e) {

            }
            totalJava++;
        }
    }
}
