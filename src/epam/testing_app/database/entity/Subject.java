package epam.testing_app.database.entity;

import java.sql.Timestamp;
/**
 * Subject entity.
 *
 * @author V.Dorosh
 *
 */
public class Subject extends Entity {

    private static final long serialVersionUID = -9049755815701526607L;

    private String nameEN;
    private String nameUA;
    private String descriptionEN;
    private String descriptionUA;
    private int adminId;
    private Timestamp createdOn;

    public static Subject createSubject(String nameEN, String nameUA, String descriptionEN, String descriptionUA, int adminId) {
        Subject subject = new Subject();

        subject.setId(0L);
        subject.setNameEN(nameEN);
        subject.setNameUA(nameUA);
        subject.setDescriptionEN(descriptionEN);
        subject.setDescriptionUA(descriptionUA);
        subject.setAdminId(adminId);
        return subject;
    }

    @Override
    public String toString() {
        return "ID [" + getId() + "] " + " NameUA [" + nameUA + "]" + " NameEN [" + nameEN + "]" +
                " DescriptionUA [" + descriptionUA + "]" + " DescriptionEN [" + descriptionEN + "]" +
                " AdminID [" + adminId + "]" + " CreateTime [" + createdOn + "]";
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getNameUA() {
        return nameUA;
    }

    public void setNameUA(String nameUA) {
        this.nameUA = nameUA;
    }

    public String getDescriptionEN() {
        return descriptionEN;
    }

    public void setDescriptionEN(String descriptionEN) {
        this.descriptionEN = descriptionEN;
    }

    public String getDescriptionUA() {
        return descriptionUA;
    }

    public void setDescriptionUA(String descriptionUA) {
        this.descriptionUA = descriptionUA;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

}
