package com.shl.onetest.constant;

/**
 * @Author:songhongli
 * @Created: 2018/7/11
 */
public enum SexEnum {
    SEX_Man("man"),
    SEX_WoMan("woman");

    private String sex;
    SexEnum(String sex){
        this.sex = sex;
    }

    public String getSexEnum() {
        return sex;
    }
}
