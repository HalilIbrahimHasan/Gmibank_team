package stepDefs;

import pages.LoginPage;
import pages.RegistrationPage;
import pages.UserManagementPage;
import pojos.Registrant;

public class BaseSteps {
    public static LoginPage lp = null;
    public static RegistrationPage rp = null;
    public static UserManagementPage ump = null;

    protected static Registrant registrant = new Registrant();

    public static void initPages(){
        lp = new LoginPage();
        rp = new RegistrationPage();
        ump = new UserManagementPage();
    }
}
