package com.wdg.bean.test;

import com.wdg.beans.Person;
import com.wdg.context.ApplicationContext;

public class Test {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ApplicationContext();
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }
}
