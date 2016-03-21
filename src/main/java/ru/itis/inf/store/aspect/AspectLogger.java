package ru.itis.inf.store.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by rumia on 17.03.16.
 */
@Aspect
public class AspectLogger {

    @Before("execution(* * ..ru.itis.inf.store.dao.reader.CsvReader.getData(..))")
    public void f(JoinPoint point){
        System.out.println("AOP logging: dao init");
    }

    @After("initialization(ItemsDaoHashMapImpl.new())")
    public void f1(){
        System.out.println("AOP logging: dao init");
    }

    @After("execution(* * ..ru.itis.inf.store.dao.delete(String))")
    public void f2(JoinPoint jp){
        System.out.println("AOP logging: " + jp.toShortString());
    }

    @After("execution(* * ..ru.itis.inf.store.dao.select(String))")
    public void f3(JoinPoint jp){
        System.out.println("AOP logging: " + jp.toShortString());
    }
}
