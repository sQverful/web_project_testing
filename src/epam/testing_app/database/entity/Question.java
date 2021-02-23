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
    private int testId;

    public static Question createQuestion(String questionUA, String questionEN, int testId) {
        Question question = new Question();
        question.setQuestionEN(questionEN);
        question.setQuestionUA(questionUA);
        question.setTestId(testId);
        return question;
    }

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

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    @Override
    public String toString() {
        return "Question [id=" + getId() + ", questionEN=" + questionEN +
                ", questionUA" + questionUA + ", testID=" + testId + "]";
    }
}
