package utilities;

import io.cucumber.datatable.DataTable;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojos.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ApiValidations {

    public static List<String> getSSNData (Customer[] data){

        List<String> ssnData = new ArrayList<>();

        for (Customer cs : data){
            ssnData.add(cs.getSsn());
        }

        return ssnData;
    }


    public static boolean ssnMatch(List<String> actulSSNData, List<String> expectedSSNData){

        Assert.assertTrue(actulSSNData.containsAll(expectedSSNData));

        return  actulSSNData.containsAll(expectedSSNData);
    }

    public static void setPathParams(DataTable dataTable, RequestSpecification spec){
        // Convert DataTable to a List of Lists (each row is a List)
        List<List<String>> data = dataTable.asLists(String.class);


        // Get the header row (param1, param2, param3)
        List<String> header = data.get(0);

        // Get the first data row (values for param1, param2, param3)
        List<String> values = data.get(1);

        //api/tp-countries
        // Extract individual parameters by column index
        String param1 = values.get(0); // First column (param1)
        String param2 = values.get(1); // Second column (param2)

       if(param1 != null && param2 != null ){
            spec.pathParams("first", param1, "second", param2);
        }else if(param1 != null ){
            spec.pathParams("first", param1);
        }


    }

    public static void sendRequestWithThreeParams(DataTable dataTable, RequestSpecification spec){
        // Convert DataTable to a List of Lists (each row is a List)
        List<List<String>> data = dataTable.asLists(String.class);

        // Get the header row (param1, param2, param3)
        List<String> header = data.get(0);

        // Get the first data row (values for param1, param2, param3)
        List<String> values = data.get(1);


        // Extract individual parameters by column index
        String param1 = values.get(0); // First column (param1)
        String param2 = values.get(1); // Second column (param2)
        String param3 = values.get(2); // Second column (param3)
        if(param1 != null && param2 != null&& param3 != null ){
            spec.pathParams("first", param1, "second", param2, "third", param3);
        }else if(param1 != null && param2 != null ){
            spec.pathParams("first", param1, "second", param2);
        }else if(param1 != null ){
            spec.pathParams("first", param1);
        }


    }

    public static List<String> getSSNData (List<Customer> data){

        List<String> ssnData = new ArrayList<>();

        for (Customer cs : data){
            ssnData.add(cs.getSsn());
        }

        return ssnData;
    }
}
