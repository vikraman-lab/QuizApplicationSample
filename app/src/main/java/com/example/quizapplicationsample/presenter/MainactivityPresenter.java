package com.example.quizapplicationsample.presenter;

import android.content.Intent;

import com.example.quizapplicationsample.activity.MainActivity;
import com.example.quizapplicationsample.activity.QuestionsActivity;
import com.example.quizapplicationsample.databinding.ActivityMainBinding;

public class MainactivityPresenter  {
    private MainActivity mActivity;
    private ActivityMainBinding mBinding;


    public MainactivityPresenter(MainActivity mainActivity, ActivityMainBinding activityMainBinding) {
        this.mActivity=mainActivity;
        this.mBinding=activityMainBinding;

    }

    public void onClick(){
        String name=mBinding.editName.getText().toString();
        Intent intent=new Intent(mActivity, QuestionsActivity.class);
        intent.putExtra("myname",name);
        mActivity.startActivity(intent);
    }
}
