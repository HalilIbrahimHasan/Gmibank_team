package stepDefs;

import pages.EmployeeUserManagementPage;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.UserManagementPage;
import pojos.Registrant;

public class BaseSteps {
    public static LoginPage lp = null;
    public static RegistrationPage rp = null;
    public static UserManagementPage ump = null;
    public static EmployeeUserManagementPage eump = null;

    protected static Registrant registrant = new Registrant();

    public static void initPages(){
        lp = new LoginPage();
        rp = new RegistrationPage();
        ump = new UserManagementPage();
        eump = new EmployeeUserManagementPage();
    }
}
