package com.example.quizapplicationsample.apiInterface;



import com.example.quizapplicationsample.models.QuestionResponseModels;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://api.myjson.com/bins/";


    @GET("qh7ke")
    Call<QuestionResponseModels> getMainDataResponse();

}
