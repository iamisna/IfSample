package com.test;

public interface SampleInterface {
    public String validate(String data1, String data2);
}

class SampleA implements SampleInterface {

    @Override
    public String validate(String data1, String data2) {
        return "A :" + data1 + " " + data2;

    }
}

class SampleB implements SampleInterface {

    @Override
    public String validate(String data1, String data2) {
        return "B :" + data1 + " " + data2;
    }
}

class SampleC implements SampleInterface {

    @Override
    public String validate(String data1, String data2) {
        return "C :"+ data1 +" " + data2;
    }
}
