package epam.testing_app.database.entity;

/**
 * Role entity.
 *
 * @author V.Dorosh
 */
public enum Role {
    ADMIN, STUDENT;

    public static Role getRole(User user) {
        int roleId = user.getRoleId();
        switch (roleId) {
            case 1:
                return STUDENT;
            case 2:
                return ADMIN;
        }
        return null;
    }

    public String getName() {
        return name().toLowerCase();
    }

    public static void main(String[] args) {
        User user = User.createUser("test", "test", "test",
                "test@test.com", "test", false, 1);
        System.out.println(Role.getRole(user));
    }
}
