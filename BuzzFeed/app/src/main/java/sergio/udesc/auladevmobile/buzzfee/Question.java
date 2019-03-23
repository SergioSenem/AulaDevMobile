package sergio.udesc.auladevmobile.buzzfee;

import java.util.ArrayList;

public class Question {
    public String title;
    public ArrayList<Answer> answers;

    public Question(String title){
        this.title = title;
        answers = new ArrayList<Answer>();
    }

    public Question addAnswer(Answer answer){
        this.answers.add(answer);
        return this;
    }
}