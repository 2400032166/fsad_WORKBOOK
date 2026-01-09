package com.klu_wb4.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu_wb4.model.Student;

public class MainXML {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");

        Student student = context.getBean("student", Student.class);
        student.display();
    }
}
