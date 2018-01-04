package com.hncs.dktlh.ppdelivery.model.personal.courier;

import java.io.Serializable;

/**
 * Created by dengkaitao on 2018/1/3 15:28.
 * Email：724279138@qq.com
 */

public class Section2Info implements Serializable {

    private String number;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }
}
