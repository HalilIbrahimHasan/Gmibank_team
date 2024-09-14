package utilities;

import pojos.Registrant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TxtWriter {




    public static void txtRegistrantWriter(String fName, Registrant registrant){
        String fileName = ConfigurationReader.getProperty("test_data_path")+fName;  // Specify the file name
        String content = "This is the content to write into the file.";  // Content to write

        try {

            //Bu dosyayi bizim icin olusturuyor
            FileWriter fileWriter = new FileWriter(fileName,true);
            //Burasi olusan dosyanin icine yaziyor
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(registrant.getFirstName()+",");
            writer.write(registrant.getLastName()+",");
            writer.write(registrant.getAddress()+",");
            writer.write(registrant.getSsn()+",");
            writer.write(registrant.getPassword()+",");
            writer.write(registrant.getUserName()+",");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();  // Handle any IO exceptions
        }
    }
}
