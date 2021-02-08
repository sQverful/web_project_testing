package epam.testing_app.database.entity;

import java.sql.Timestamp;
/**
 * Test entity.
 *
 * @author V.Dorosh
 *
 */
public class Test extends Entity{

    private static final long serialVersionUID = 8212021709852657516L;

    private String nameEN;
    private String nameUA;
    private String descriptionEN;
    private String descriptionUA;
    private int subjectId;
    private boolean blocked;
    private int complexity;
    private int requestsQuantity;
    private int timer;
    private Timestamp createdOn;


    public static Test createTest(String nameEN, String nameUA, String descriptionEN, String descriptionUA, int subjectId,
                boolean blocked, int complexity, int requestsQuantity, int timer) {
        Test test = new Test();
        test.setId(0L);
        test.setNameEN(nameEN);
        test.setNameUA(nameUA);
        test.setDescriptionEN(descriptionEN);
        test.setDescriptionUA(descriptionUA);
        test.setSubjectId(subjectId);
        test.setBlocked(blocked);
        test.setComplexity(complexity);

        return test;

    }


    @Override
    public String toString() {
        return "ID [" + getId() + "]" + " NameEN [" + nameEN +  "]" + " NameUA [" + nameUA +  "]"
                + " DescriptionEN [" + descriptionEN +  "]" + " DescriptionUA [" + descriptionUA +  "]" +
                " SubjectId [" + subjectId +  "]" + " Blocked [" + blocked +  "]" + " Complexity [" + complexity +  "]";
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

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getRequestsQuantity() {
        return requestsQuantity;
    }

    public void setRequestsQuantity(int requestsQuantity) {
        this.requestsQuantity = requestsQuantity;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }
}
