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
        return Role.values()[roleId];
    }

    public String getName() {
        return name().toLowerCase();
    }

}
