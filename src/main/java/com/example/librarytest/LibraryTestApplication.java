package com.example.librarytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryTestApplication {

    public static void main(String[] args) {
                                             //这里换为自己的hadoop地址
        System.setProperty("hadoop.home.dir", "/home/zz/data/hadoop");
        SpringApplication.run(LibraryTestApplication.class, args);
    }

}
