package javacompiler;

//The other java class are in the same folder


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaCompiler {

    public static void main(String[] args) throws Exception {
        pbuilder("javac -d . HelloWorld.java");
        pbuilder("java javacompiler.HelloWorld");
    }

    public static void pbuilder(String commandString) {
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd \"C:\\Users\\Badrul\\Documents\\NetBeansProjects\\JavaCompiler\\src\\javacompiler\" && " + commandString);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}