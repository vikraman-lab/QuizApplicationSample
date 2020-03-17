package com.example.quizapplicationsample.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.quizapplicationsample.R;
import com.example.quizapplicationsample.databinding.ActivityQuestionsBinding;
import com.example.quizapplicationsample.presenter.QuestionsActivityPresenter;

public class QuestionsActivity extends AppCompatActivity {
    private ActivityQuestionsBinding mActivityQuestionsBinding;
    private QuestionsActivityPresenter mQuestionsActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityQuestionsBinding = DataBindingUtil.setContentView(this, R.layout.activity_questions);
        Intent intent = getIntent();
        String name = intent.getStringExtra("myname");
        if (name.trim().equals(""))
            mActivityQuestionsBinding.DispName.setText("Hello User");
        else
            mActivityQuestionsBinding.DispName.setText("Hello " + name);
        mQuestionsActivityPresenter = new QuestionsActivityPresenter(this, mActivityQuestionsBinding);
        mActivityQuestionsBinding.setPresenter(mQuestionsActivityPresenter);
    }
}
