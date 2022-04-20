package com.example.finaltest;

public class QuizDetails {
    String question_num;
    String question_detail;
    String answer;

    public String getQuestion_num() {
        return question_num;
    }

    public void setQuestion_num(String question_num) {
        this.question_num = question_num;
    }

    public String getQuestion_detail() {
        return question_detail;
    }

    public void setQuestion_detail(String question_detail) {
        this.question_detail = question_detail;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }



    public QuizDetails(String question_detail, String question_num, String answer) {
        this.question_detail = question_detail;
        this.question_num=question_num;
        this.answer=answer;
    }

    public QuizDetails() {

    }


}
