package com.example.quizapplicationsample.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionResponseModels implements Parcelable {
    @SerializedName("questions")
    @Expose
    private List<Question> questions = null;

    protected QuestionResponseModels(Parcel in) {
        questions = in.createTypedArrayList(Question.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(questions);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionResponseModels> CREATOR = new Creator<QuestionResponseModels>() {
        @Override
        public QuestionResponseModels createFromParcel(Parcel in) {
            return new QuestionResponseModels(in);
        }

        @Override
        public QuestionResponseModels[] newArray(int size) {
            return new QuestionResponseModels[size];
        }
    };

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "QuestionResponseModels{" +
                "questions=" + questions +
                '}';
    }
}
