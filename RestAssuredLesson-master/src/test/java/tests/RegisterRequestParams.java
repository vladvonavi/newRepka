package tests;

import java.util.Arrays;

public enum RegisterRequestParams {
    Email("sobaka@ya.ru", "kot@gmail.com"),
    Password("123456", "654321");
    private String[] strings;

    private RegisterRequestParams(String... strings){
        this.strings=strings;
    }

    public String toString(){
        return Arrays.toString(strings);
    }

    public String getString(int index){
        return strings[index];
    }
}
