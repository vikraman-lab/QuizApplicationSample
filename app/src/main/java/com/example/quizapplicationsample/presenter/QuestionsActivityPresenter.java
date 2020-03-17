package com.example.quizapplicationsample.presenter;

import android.content.Intent;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.quizapplicationsample.activity.QuestionsActivity;
import com.example.quizapplicationsample.activity.ResultActivity;
import com.example.quizapplicationsample.apiInterface.Api;
import com.example.quizapplicationsample.databinding.ActivityQuestionsBinding;
import com.example.quizapplicationsample.models.QuestionResponseModels;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionsActivityPresenter {
    private QuestionsActivity mQuestionsActivity;
    private ActivityQuestionsBinding mActivityQuestionsBinding;
    private static final String TAG = "QuestionsActivityPresen";
    private int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;
    private QuestionResponseModels questionResponseModels;

    public QuestionsActivityPresenter(QuestionsActivity questionsActivity, ActivityQuestionsBinding binding) {
        this.mQuestionsActivity = questionsActivity;
        this.mActivityQuestionsBinding = binding;
        callapi();


    }

    private void callapi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<QuestionResponseModels> questionResponseModelsCall = api.getMainDataResponse();
        questionResponseModelsCall.enqueue(new Callback<QuestionResponseModels>() {
            @Override
            public void onResponse(Call<QuestionResponseModels> call, Response<QuestionResponseModels> response) {
                Log.d(TAG, "onResponse-->" + response);
                questionResponseModels = response.body();
                setView(questionResponseModels);
            }

            @Override
            public void onFailure(Call<QuestionResponseModels> call, Throwable t) {
                Log.d(TAG, "onFailure-->" + t.toString());
            }
        });
    }

    private void setView(QuestionResponseModels questionResponseModels) {
        Log.d(TAG, "setView-->" + questionResponseModels.toString());

        mActivityQuestionsBinding.tvque.setText(questionResponseModels.getQuestions().get(0).getQuestion());
        mActivityQuestionsBinding.radioButton.setText(questionResponseModels.getQuestions().get(0).getAnswers().get(0));
        mActivityQuestionsBinding.radioButton2.setText(questionResponseModels.getQuestions().get(0).getAnswers().get(1));
        mActivityQuestionsBinding.radioButton3.setText(questionResponseModels.getQuestions().get(0).getAnswers().get(2));
        mActivityQuestionsBinding.radioButton4.setText(questionResponseModels.getQuestions().get(0).getAnswers().get(3));

    }

    public void onClickNextQuestion() {
        if (mActivityQuestionsBinding.answersgrp.getCheckedRadioButtonId() == -1) {
            Toast.makeText(mQuestionsActivity, "Please select one choice", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton uans = (RadioButton) mQuestionsActivity.findViewById(mActivityQuestionsBinding.answersgrp.getCheckedRadioButtonId());
        //  RadioButton radioButton=mActivityQuestionsBinding.answersgrp.getCheckedRadioButtonId();
        String ansText = uans.getText().toString();
        if (ansText.equals(questionResponseModels.getQuestions().get(flag).getAnswers().get(questionResponseModels.getQuestions().get(flag).getCorrectIndex()))) {
            correct++;
            Toast.makeText(mQuestionsActivity, "Correct", Toast.LENGTH_SHORT).show();
        } else {
            wrong++;
            Toast.makeText(mQuestionsActivity, "Wrong", Toast.LENGTH_SHORT).show();
        }
        flag++;
       mActivityQuestionsBinding.textView4.setText(""+correct);
        if (flag < questionResponseModels.getQuestions().size()-1) {
            mActivityQuestionsBinding.tvque.setText(questionResponseModels.getQuestions().get(flag).getQuestion());
            mActivityQuestionsBinding.radioButton.setText(questionResponseModels.getQuestions().get(flag).getAnswers().get(0));
            mActivityQuestionsBinding.radioButton2.setText(questionResponseModels.getQuestions().get(flag).getAnswers().get(1));
            mActivityQuestionsBinding.radioButton3.setText(questionResponseModels.getQuestions().get(flag).getAnswers().get(2));
            mActivityQuestionsBinding.radioButton4.setText(questionResponseModels.getQuestions().get(flag).getAnswers().get(3));
        } else {
            marks = correct;
            Intent in = new Intent(mQuestionsActivity, ResultActivity.class);
            mQuestionsActivity.startActivity(in);
        }

        mActivityQuestionsBinding.answersgrp.clearCheck();
    }
}
