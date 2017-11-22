package com.exm.myrpc.testLombok;

import lombok.Cleanup;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MyTest {

    @Test
    public void testData(){
        User u = new User();
        u.setName("sdf");
        u.setAge(13);
        System.out.println(u.toString());
        set(null);
        System.out.println("--end--");
    }

    @Test
    @SneakyThrows
    public void testStream(){
        @Cleanup InputStream in = new ByteArrayInputStream("helloworld".getBytes());
        System.out.println(in.available());
    }

    public void set(@NonNull String a){
        String content = String.format("hello,%s",a);
        System.out.println(content);
    }

    @Test
    public void testStu(){
        Student s = new Student();
        s.setId(1);
        s.setName("xiaoming");
        s.setPhone("123");
        System.out.println(s.toString());
    }
}
