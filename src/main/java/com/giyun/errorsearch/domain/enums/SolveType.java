package com.giyun.errorsearch.domain.enums;

public enum SolveType {
    SOLVE("해결"),
    UNSOLVED("미해결");

    private String value;

    SolveType(String value){this.value=value;}
    public String getValue(){return this.value;}
}
