package com.example.gilberttsai.bigapp.GeoQuiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gilberttsai.bigapp.R;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueBtn;
    private Button mFalseBtn;
    private TextView mQuestionTexView;
    private Button mNextBtn;
    private Button mPrevBtn;
    private TrueFalse[] mQuestions={new TrueFalse(R.string.question_one,true),new TrueFalse(R.string.question_two,true)
    ,new TrueFalse(R.string.question_third,false),new TrueFalse(R.string.question_fourth,true),new TrueFalse(R.string.question_fifth,false)};
    private int mCurrentIndex=0;
    private static final String KEY_INDEX="index";
    private static final String TAG="QuizActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_quiz);

        if(savedInstanceState!=null){
            mCurrentIndex=savedInstanceState.getInt(KEY_INDEX);
        }
        mTrueBtn= (Button) findViewById(R.id.true_btn);
        mFalseBtn= (Button) findViewById(R.id.false_btn);
        mTrueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        mFalseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mQuestionTexView= (TextView) findViewById(R.id.question_tv);

        updateQuestion();
        mNextBtn= (Button) findViewById(R.id.next_btn);
        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这样写超过大小后不会闪退
                mCurrentIndex=(mCurrentIndex+1)%mQuestions.length;
                updateQuestion();
            }
        });
        mQuestionTexView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNextBtn.performClick();
            }
        });

        mPrevBtn= (Button) findViewById(R.id.prev_btn);
        mPrevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentIndex==0){
                    mCurrentIndex=mQuestions.length-1;
                }else{
                    mCurrentIndex=(mCurrentIndex-1)%mQuestions.length;
                }
                updateQuestion();
            }
        });
    }

    private void checkAnswer(boolean b) {
        int msg=0;
        if(b==mQuestions[mCurrentIndex].isTrueQuestion()){
            msg=R.string.correct_toast;
        }else{
            msg=R.string.incorrect_toast;
        }
        Toast.makeText(QuizActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    private void updateQuestion() {
        mQuestionTexView.setText(mQuestions[mCurrentIndex].getQuestion());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
        outState.putInt(KEY_INDEX,mCurrentIndex);

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}
