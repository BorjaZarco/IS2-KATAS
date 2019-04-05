package kata5;


import sql_management.ConnectApp;
import sql_management.SQLTable;
import sql_management.SelectApp;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public  class Main {
    public static void main(String[] args) throws IOException {
//        List<String> emails = MailListReader.read("email.txt");
        SQLTable sqlTable =  new SQLTable("EMAIL", ConnectApp.connect());
//        for (String email : emails) {
//            sqlTable.insert(email);
//        }
        sqlTable.select("*");
    }
}
