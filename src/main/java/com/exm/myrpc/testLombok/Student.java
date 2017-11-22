package com.exm.myrpc.testLombok;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true) //(exclude = {"id"})
public class Student {

    @Getter(AccessLevel.PROTECTED) @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private String phone;
}
