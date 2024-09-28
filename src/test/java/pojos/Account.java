package pojos;

public class Account {


    private String description;
    private String balance;
    private String accountType;
    private String accountStatus;
    private String createdDate;
    private String closedDate;
    private Registrant registrant;

    public Account() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    public Registrant getRegistrant() {
        return registrant;
    }

    public void setRegistrant(Registrant registrant) {
        this.registrant = registrant;
    }

    public void setAccountValues(String header, String input){
        if(header.equalsIgnoreCase("Description")){
            setDescription(input);
        }
        if(header.equalsIgnoreCase("Balance")){
            setBalance(input);
        }

    }

    @Override
    public String toString() {
        return "Account{" +
                "description='" + description + '\'' +
                ", balance='" + balance + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", closedDate='" + closedDate + '\'' +
                ", registrant=" + registrant +
                '}';
    }
}
