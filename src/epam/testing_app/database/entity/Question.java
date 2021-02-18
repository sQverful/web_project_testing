package epam.testing_app.database.entity;
/**
 * Question entity.
 *
 * @author V.Dorosh
 *
 */
public class Question extends Entity {

    private static final long serialVersionUID = -1780400943337366682L;

    private String questionEN;
    private String questionUA;
    private Long testId;

    public String getQuestionEN() {
        return questionEN;
    }

    public void setQuestionEN(String questionEN) {
        this.questionEN = questionEN;
    }

    public String getQuestionUA() {
        return questionUA;
    }

    public void setQuestionUA(String questionUA) {
        this.questionUA = questionUA;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    @Override
    public String toString() {
        return "Question [id=" + getId() + ", questionEN=" + questionEN +
                ", questionUA" + questionUA + ", testID=" + testId + "]";
    }
}
