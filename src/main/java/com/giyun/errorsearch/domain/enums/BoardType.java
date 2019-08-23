package com.giyun.errorsearch.domain.enums;

public enum BoardType {
    solve("해결"),
    unsolved("미해결");

    private String value;

    BoardType(String value){
        this.value=value;
    }
    public String getValue(){
        return this.value;
    }
}
