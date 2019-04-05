package kata5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailListReader {

    public static List read(String fileName) throws IOException {
        List<String> emailList = new ArrayList();
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = in.readLine()) != null) {
                if (isEmail(line)) {
                    emailList.add(line);
                }
            }
        }
        return emailList;
    }

    private static boolean isEmail(String email) {
        Pattern p = Pattern.compile("@");
        Matcher m = p.matcher(email);
        return m.find();
    }
}
