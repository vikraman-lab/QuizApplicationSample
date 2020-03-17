package com.example.quizapplicationsample.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question implements Parcelable {

    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("answers")
    @Expose
    private List<String> answers = null;
    @SerializedName("correctIndex")
    @Expose
    private Integer correctIndex;

    protected Question(Parcel in) {
        question = in.readString();
        answers = in.createStringArrayList();
        if (in.readByte() == 0) {
            correctIndex = null;
        } else {
            correctIndex = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeStringList(answers);
        if (correctIndex == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(correctIndex);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public Integer getCorrectIndex() {
        return correctIndex;
    }

    public void setCorrectIndex(Integer correctIndex) {
        this.correctIndex = correctIndex;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answers=" + answers +
                ", correctIndex=" + correctIndex +
                '}';
    }
}