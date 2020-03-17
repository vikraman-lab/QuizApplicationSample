package com.example.quizapplicationsample.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.quizapplicationsample.R;
import com.example.quizapplicationsample.databinding.ActivityMainBinding;
import com.example.quizapplicationsample.presenter.MainactivityPresenter;

public class MainActivity extends AppCompatActivity {
    private  ActivityMainBinding mBinding;
    private MainactivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);
       mPresenter=new MainactivityPresenter(this,mBinding);
       mBinding.setPresenter(mPresenter);

    }
}
