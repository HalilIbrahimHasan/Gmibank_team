package constants;

public enum Role {
    ROLE_ADMIN, ROLE_USER, ROLE_EMPLOYEE, ROLE_MANAGER, ROLE_CUSTOMER;

    public static Role getRoleFromString(String roleStr) {
        try {
            return Role.valueOf(roleStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid role: " + roleStr);
            return null; // Or handle accordingly
        }
    }

    public static void activateRole(Role role) {
        if (role != null) {
            System.out.println("Activating role: " + role);
            // Logic to activate the role
        }
    }


}
