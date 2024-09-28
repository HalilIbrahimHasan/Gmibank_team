package stepDefs;

import utilities.DatabaseUtility;

public class DBDummy {

    public static void main(String[] args) {
        DatabaseUtility.createConnection();
        DatabaseUtility.getColumnData("Select * from tp_country", "id");
    }



}
