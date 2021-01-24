package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("interface==");
        interfaceNotIf();
        System.out.println("lambda==");
        lambdaNotIf();
        System.out.println("try==");
        tryLambdaNotIf();
    }

    //interface 를 이용한 클래스 분류.
    public static void interfaceNotIf() {
        Map<String, SampleInterface> typeMap = new HashMap<>();

        String request = "B";
        String compare = "A";

        String data1 = "TEST";
        String data2 = "TEST1";

        // reuqest 데이터가 null 일경우
        typeMap.put(null, new SampleA());
        // request 데이터가 빈값 일 경우
        typeMap.put("", new SampleB());
        // request 데이터가 일치 할경우
        typeMap.put(compare, new SampleC());
        // request 데이터가 불일치 할경우.
        typeMap.put("notCompare", new SampleB());

        String str = typeMap.get(request)==null?typeMap.get("notCompare").validate(data1, data2):typeMap.get(request).validate(data1, data2);

        System.out.println(str);
    }

    //lambda 를 이용한 함수.
    public static void lambdaNotIf() {
//        Map<String, String> param = new HashMap<>();

        Map<String, BiFunction<Integer, String, String>> typeMap = new HashMap<>();

        String request = "B";
        String compare = "A";

        int data1Param = 1;
//        int data2Param = 2;

//        String data1Param = "TEST";
        String data2Param = "TEST1";

        typeMap.put(null, (data1, data2)-> "requset 데이터가 NULL : "+ data1 + " " + data2);
        typeMap.put("", (data1, data2)-> "request 데이터가 빈값 : "+ data1 + " " + data2);
        typeMap.put(compare, (data1, data2)-> { return "request, compare 데이터가 일치 : "+ data1 + " " + data2; } );
        typeMap.put("notCompare", (data1, data2)-> { return testD(data1, data2); });

        String str = typeMap.get(request)==null?
                     typeMap.get("notCompare").apply(data1Param,data2Param):typeMap.get(request).apply(data1Param,data2Param);

        System.out.println(str);
    }

    public static String testA(String data1, String data2) {
        return "TestA : "+ data1 + " " + data2;
    }
    public static String testB(String data1, String data2) {
        return "TestB : "+ data1 + " " + data2;
    }
    public static String testC(String data1, String data2) {
        return "TestC : "+ data1 + " " + data2;
    }
    public static String testD(int data1, String data2) {
        return "reuest, compare 데이터가 불일치 : "+ data1 + " " + data2;
    }

    //lambda 를 이용한 함수.
    public static void tryLambdaNotIf() {
//        Map<String, String> param = new HashMap<>();

        Map<String, BiFunction<Integer, String, String>> typeMap = new HashMap<>();

        String request = "B";
        String compare = "A";

        int data1Param = 1;
//        int data2Param = 2;

//        String data1Param = "TEST";
        String data2Param = "TEST1";

        typeMap.put(null, (data1, data2)-> "requset 데이터가 NULL : "+ data1 + " " + data2);
        typeMap.put("", (data1, data2)-> "request 데이터가 빈값 : "+ data1 + " " + data2);
        typeMap.put(compare, (data1, data2)-> { return "request, compare 데이터가 일치 : "+ data1 + " " + data2; } );
        typeMap.put("notCompare", (data1, data2)-> { return testD(data1, data2); });


        String str = "";

        try {
            str = typeMap.get(request).apply(data1Param,data2Param);
        } catch (NullPointerException npe) {
            str = typeMap.get("notCompare").apply(data1Param,data2Param);
        }

        System.out.println(str);
    }

}
