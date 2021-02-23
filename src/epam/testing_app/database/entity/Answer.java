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
    private int questionId;

    public static Answer createAnswer(String answerEN, String answerUA, boolean correct, int questionId) {
        Answer answer = new Answer();
        answer.setAnswerEN(answerEN);
        answer.setAnswerUA(answerUA);
        answer.setCorrect(correct);
        answer.setQuestionId(questionId);
        return answer;

    }

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

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "Answer [id=" + getId() + ", answerEN=" + answerEN +
                ", answerUA=" + answerUA + ", correct=" + correct +
                ", questionId=" + questionId + "]";
    }
}
