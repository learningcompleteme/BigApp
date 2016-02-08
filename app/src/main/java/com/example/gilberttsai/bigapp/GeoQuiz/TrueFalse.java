package com.example.gilberttsai.bigapp.GeoQuiz;
 //study commit code

public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;

    public TrueFalse(int mQuestion, boolean mIsTure) {
        this.mQuestion = mQuestion;
        this.mTrueQuestion = mIsTure;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public void setTrueQuestion(boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
    }
}
