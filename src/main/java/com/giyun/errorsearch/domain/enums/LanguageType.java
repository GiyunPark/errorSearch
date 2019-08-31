package com.giyun.errorsearch.domain.enums;

public enum LanguageType {
    JAVA("자바"),
    C("C언어"),
    ETC("기타");


    private String value;

    LanguageType(String value){
        this.value=value;
    }
    public String getValue(){
        return this.value;
    }
}
