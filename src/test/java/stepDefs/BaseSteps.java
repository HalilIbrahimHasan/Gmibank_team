package stepDefs;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import pages.*;
import pojos.*;
import pages.EmployeeUserManagementPage;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.UserManagementPage;
import utilities.VideoRecord;

import java.util.ArrayList;
import java.util.List;

public class BaseSteps {
    protected static LoginPage lp = null;
    protected static RegistrationPage rp = null;
    protected static UserManagementPage ump = null;
    protected static AccountManagementPage amp = null;
    protected static CommonPageElements cpe = null;
    protected static VideoRecord videoRecord =null;
    protected static CustomerManagementPage cmp = null;
    public static EmployeeUserManagementPage eump = null;

    protected static Registrant registrant = new Registrant();
    protected static Customer customer = new Customer();
    protected static List<Customer> customers = new ArrayList<>();
    protected static Account account =null;
    protected static Country country = null;
    protected static CountryU countryU = null;
    public static List<Account> accounts = new ArrayList<>();
    protected static Faker faker = new Faker();
    protected static Response response;

    public static void initPages(){
        lp = new LoginPage();
        rp = new RegistrationPage();
        ump = new UserManagementPage();
        amp = new AccountManagementPage();
        cpe = new CommonPageElements();
        cmp = new CustomerManagementPage();
        account = new Account();
        videoRecord = new VideoRecord();
        eump = new EmployeeUserManagementPage();
        country = new Country();
        countryU = new CountryU();

    }
}
