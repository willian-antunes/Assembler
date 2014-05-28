package assembler;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Willian Antunes on 5/14/14.
 */
public class AssemblyReader {

    public static void main(String[] args) throws IOException {
        String everything = new String();
        int linesCounter = 0;

        BufferedReader br = new BufferedReader(new FileReader("/Users/Lorini/IdeaProjects/src/main/resources/files/Pong.asm"));

        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                if (line.startsWith("//")) {
                } else {
                    if (line.startsWith("(") && line.endsWith(")")) {
                        System.out.print("Label found!");
                    }
                    sb.append(line);
                    sb.append(System.lineSeparator());
                }
                line = br.readLine();
            }
            everything = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        String[] tokens = everything.split(" |\\;|\\=|\\\n");
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].length() > 1) {
                switch (tokens[i].charAt(0)) {
                    case '@':
                        String aux = tokens[i].substring(1);
                        if (isNumber(aux)) {
                            int number = Integer.parseInt(aux);
                            System.out.print(Integer.toBinaryString(number) + "\n");
                        }
                }
            }
        }
    }

    private static boolean isNumber(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
