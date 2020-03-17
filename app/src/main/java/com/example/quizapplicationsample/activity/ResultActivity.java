package com.example.quizapplicationsample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapplicationsample.R;
import com.example.quizapplicationsample.presenter.QuestionsActivityPresenter;

public class ResultActivity extends AppCompatActivity {
    TextView tv, tv2, tv3;
    Button btnRestart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);
        btnRestart = (Button) findViewById(R.id.btnRestart);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + QuestionsActivityPresenter.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + QuestionsActivityPresenter.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + QuestionsActivityPresenter.correct + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        QuestionsActivityPresenter.correct=0;
        QuestionsActivityPresenter.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }

}
