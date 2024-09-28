package utilities;

import pojos.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadTxtFile {


    public static Customer getLastUser(String path){

        String filePath = System.getProperty("user.dir")+
                ConfigurationReader.getProperty("test_data_path") + path; // Replace with your file path

        List<Customer > allCustomers = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null) {
                Customer customer = new Customer();
                String [] data = line.split(",");

                if(data[3] != null) {
                    customer.setSsn(data[3]);
                }
                if(data[2] != null) {
                    customer.setEmail(data[2]);
                }
                if(data[4] != null) {
                    customer.setPassword(data[4]);
                }
                if(data[5] != null) {
                    customer.setLogin(data[5]);
                }
                allCustomers.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allCustomers.get(allCustomers.size()-1);
    }

    public static List<Customer> getAllUsers(String path){

        String filePath = System.getProperty("user.dir")+
                ConfigurationReader.getProperty("test_data_path") + path; // Replace with your file path

        List<Customer > allCustomers = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null) {
                Customer customer = new Customer();
                String [] data = line.split(",");

                if(data[3] != null) {
                    customer.setSsn(data[3]);
                }
                if(data[2] != null) {
                    customer.setEmail(data[2]);
                }
                if(data[4] != null) {
                    customer.setPassword(data[4]);
                }
                if(data[5] != null) {
                    customer.setLogin(data[5]);
                }
                allCustomers.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allCustomers;
    }


}
