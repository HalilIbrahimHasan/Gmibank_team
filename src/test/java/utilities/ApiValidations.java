package utilities;

import org.junit.Assert;
import pojos.Customer;

import java.util.ArrayList;
import java.util.List;



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

    public static List<String> getSSNData (List<Customer> data){

        List<String> ssnData = new ArrayList<>();

        for (Customer cs : data){
            ssnData.add(cs.getSsn());
        }

        return ssnData;
    }
}
