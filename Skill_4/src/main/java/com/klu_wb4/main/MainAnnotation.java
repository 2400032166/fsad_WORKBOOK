package com.klu_wb4.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.klu_wb4.config.AppConfig;
import com.klu_wb4.model.StudentAnno;

public class MainAnnotation {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        StudentAnno student = context.getBean(StudentAnno.class);
        student.display();
    }
}
