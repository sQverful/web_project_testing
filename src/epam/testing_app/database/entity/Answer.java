package epam.testing_app.database.entity;
/**
 * Answer entity.
 *
 * @author V.Dorosh
 *
 */
public class Answer extends Entity {

    private static final long serialVersionUID = 1950818529652345241L;
    private String answerEN;
    private String answerUA;
    private boolean correct;
    private Long questionId;

    public String getAnswerUA() {
        return answerUA;
    }

    public void setAnswerUA(String answerUA) {
        this.answerUA = answerUA;
    }

    public String getAnswerEN() {
        return answerEN;
    }

    public void setAnswerEN(String answerEN) {
        this.answerEN = answerEN;
    }

    public boolean getCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
