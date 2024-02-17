package com.example.Spring_HW6.aspects;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.Arrays;

/**
 * Класс аспекта.
 */

@Aspect
@Component
@Log
public class AspectLog {

    /***
     * Логирование действие пользователя.
     * @param joinPoint Выполняемые метод.
     * @return Результата работы выполняемого метода.
     * @throws Throwable Возможные исключения.
     */
    @Around("@annotation(com.example.Spring_HW6.aspects.TrackUserAction)")
    public Object logger(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info("Вызван метод:" + joinPoint.getSignature().getName() +
                "c аргументами: " + Arrays.toString(joinPoint.getArgs()));
        log.info("Метод " + joinPoint.getSignature().getName()
                + " завершил работу, время выполнения составило: " + executionTime + "мс.");
        return joinPoint.proceed();
    }
}
