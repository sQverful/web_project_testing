package epam.testing_app.database.entity;

import java.sql.Timestamp;
/**
 * TestResults entity.
 *
 * @author V.Dorosh
 *
 */
public class TestResults extends Entity {

    private static final long serialVersionUID = -6081990051003904748L;

    private int result;
    private int userId;
    private int testId;
    private Timestamp createdOn;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "TestResults [id=" + getId() + ", result=" + result +
                ", userId=" + userId + ", testId=" + testId +
                ", createTime=" + createdOn + "]";
    }
}
