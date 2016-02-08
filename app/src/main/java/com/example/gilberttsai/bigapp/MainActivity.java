package com.example.gilberttsai.bigapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.gilberttsai.bigapp.GeoQuiz.QuizActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mToQuizApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        mToQuizApp= (Button) findViewById(R.id.toQuizApp);
        mToQuizApp.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toQuizApp:
                Log.i("QuizApp","toQuize");
                startActivity(new Intent(MainActivity.this, QuizActivity.class));
                break;
            default:
                break;
        }

    }
}
