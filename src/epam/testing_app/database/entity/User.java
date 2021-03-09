package epam.testing_app.database.entity;

import java.sql.Timestamp;

/**
 * User entity.
 *
 * @author V.Dorosh
 */
public class User extends Entity {

    private static final long serialVersionUID = 5326457513452885222L;
    private String login;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Timestamp createTime;
    private boolean blocked;
    private int roleId;

    public static User createUser(String login, String name, String surname, String email,
                                  String password, boolean blocked, int roleId) {
        User user = new User();
        user.setId(0);
        user.setLogin(login);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(password);
        user.setBlocked(blocked);
        user.setRoleId(roleId);
        return user;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String toString() {
        return "User [id=" + getId() + ", login=" + login + ", name=" + name + ", surname=" + surname + ", email=" + email + ", blocked=" + blocked
                + ", roleID=" + roleId + ", createTime=" + createTime + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return (login.equals(((User) obj).getLogin()));
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
