package constants;

// Enum for AccountTypes
public enum AccountTypes {
    CHECKING,
    SAVING,
    INVESTING,
    CREDIT_CARD;

    // String reader for AccountTypes
    public static AccountTypes fromString(String accountType) {
        try {
            return AccountTypes.valueOf(accountType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid account type: " + accountType);
        }
    }
}