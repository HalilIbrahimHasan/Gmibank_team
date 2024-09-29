package utilities;

import pojos.Account;
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

    public static List<Account> readAccounts(String filePath) {
        // Initialize FileReader and BufferedReader
        List<Account> accounts = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(ConfigurationReader.getProperty("test_data_path2")+filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            // Read file line by line
            while ((line = bufferedReader.readLine()) != null) {
                Account account = new Account();
                account.setDescription(line.replace(",", ""));
                accounts.add(account);
            }

        } catch (IOException e) {
            // Handle any IO exceptions
            System.err.println("Error reading file: " + e.getMessage());
        }
        return accounts;
    }


}
