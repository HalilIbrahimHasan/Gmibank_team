package constants;

// Enum for AccountStatus
public enum AccountStatus {
    ACTIVE,
    SUSPENDED,
    CLOSED;

    // String reader for AccountStatus
    public static AccountStatus fromString(String accountStatus) {
        try {
            return AccountStatus.valueOf(accountStatus.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid account status: " + accountStatus);
        }
    }
}