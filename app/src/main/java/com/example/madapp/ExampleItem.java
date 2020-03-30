package com.example.madapp;

public class ExampleItem {

    private int mImageResults;

    private String mText1;

    private String mText2;

    public ExampleItem(int imageResource, String text1, String text2) {

        mImageResults = imageResource;

        mText1 = text1;

        mText2 = text2;

    }

    public int getImageResults() {

        return mImageResults;
    }

    public String getText1() {

        return mText1;
    }

    public String getText2() {

        return mText2;

    }


}
