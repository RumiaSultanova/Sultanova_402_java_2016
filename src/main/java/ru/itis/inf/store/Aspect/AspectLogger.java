package ru.itis.inf.store.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by rumia on 17.03.16.
 */
@Aspect
public class AspectLogger {

    @Before("execution(* ru.itis.inf.store.dao.reader.CsvReader.getData(..))")
    public void f(JoinPoint point){
        System.out.println("AOP logging: " + point.toShortString());
    }

    @After("initialization(ItemsDaoHashMapImpl.new())")
    public void f1(){
        System.out.println("AOP logging: dao init");
    }

}
