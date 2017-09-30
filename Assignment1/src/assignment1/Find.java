//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment1
//Matrik: #239245
//Name: #Muhammad Badrul Amin Bin Abdul Razak
package assignment1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Badrul
 */
public class Find {

    public String[] listJavaFile;

    public Find() {
        Collection<File> all = new ArrayList<>();
        addTree(new File("C:\\Users\\Badrul\\Documents\\NetBeansProjects\\Assignment1\\test"), all);
        //Change File Directory Here
        Collection<File> a = all;
        listJavaFile = filterJava(a);
    }

    static void addTree(File file, Collection<File> all) {
        File[] children = file.listFiles();
        if (children != null) {
            for (File child : children) {
                all.add(child);
                addTree(child, all);
            }
        }
    }

    static String[] filterJava(Collection<File> listAllFileName) {
        LinkedList<String> fb = new LinkedList();
        Iterator<File> a = listAllFileName.iterator();
        File c;
        while (a.hasNext()) {
            c = a.next();
            if (c.getName().endsWith(".java")) {
                fb.add(c.getAbsolutePath());
            }
        }
        String[] listJavaFile = new String[fb.size()];
        for (int i = 0; i < fb.size(); i++) {
            listJavaFile[i] = fb.get(i);
        }
        return listJavaFile;
    }
}
