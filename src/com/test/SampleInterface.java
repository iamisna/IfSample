package com.test;

public interface SampleInterface {
    public String validate(String data1, String data2, String data3);
}

class SampleA implements SampleInterface {

    @Override
    public String validate(String data1, String data2, String data3) {
        return "데이터가 NULL 일경우  :" + data1 + " " + data2;

    }
}

class SampleB implements SampleInterface {

    @Override
    public String validate(String data1, String data2, String data3) {
        return "데이터가 빈겺일 경우 :" + data1 + " " + data2;
    }
}

class SampleC implements SampleInterface {

    @Override
    public String validate(String data1, String data2, String data3) {
        return "데이터가 일치 할경우 :"+ data1 +" " + data2;
    }
}

class SampleD implements SampleInterface {

    @Override
    public String validate(String data1, String data2, String data3) {
        return "데이터가 불일치 할경우 :"+ data1 +" " + data2;
    }
}
