package com.apex.BasicSpringProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.apex.BasicSpringProject.bean.Person;
import com.apex.BasicSpringProject.bean.PersonConstructorInjection;
import com.apex.BasicSpringProject.bean.PersonFieldInjection;
import com.apex.BasicSpringProject.bean.PersonSetterInjection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProjectConfig.class);
    	
//    	Person person = (Person) applicationContext.getBean("person");
//    	
//    	Person person1 = applicationContext.getBean(Person.class);
//    	
//    	person.setName("John");
//    	System.out.println(person);
//    	
//    	System.out.println(person1);
    	
    	PersonConstructorInjection constructorInjection = (PersonConstructorInjection) applicationContext.getBean("personConInj");
    	System.out.println("constructorInjection Person Name : " + constructorInjection.getName());
    	System.out.println("constructorInjection Person Age : " + constructorInjection.getAge());
    	System.out.println("constructorInjection Person City : " + constructorInjection.getCity());
    	
    	PersonFieldInjection personFieldInjection = applicationContext.getBean(PersonFieldInjection.class);
    	System.out.println("PersonFieldInjection Person Name : " + personFieldInjection.getName());
    	System.out.println("PersonFieldInjection Person Age : " + personFieldInjection.getAge());
    	System.out.println("PersonFieldInjection Person City : " + personFieldInjection.getCity());
    	
    	PersonSetterInjection personSetterInjection = applicationContext.getBean(PersonSetterInjection.class);
    	System.out.println("PersonSetterInjection Person Name : " + personSetterInjection.getName());
    	System.out.println("PersonSetterInjection Person Age : " + personSetterInjection.getAge());
    	System.out.println("PersonSetterInjection Person City : " + personSetterInjection.getCity());
    	
//    	ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
//    	configurableApplicationContext.close();
    	AbstractApplicationContext abstractApplicationContext = (AbstractApplicationContext) applicationContext;
    	abstractApplicationContext.close();
    	
    }
}
