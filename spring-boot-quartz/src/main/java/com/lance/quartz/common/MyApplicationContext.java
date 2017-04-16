package com.lance.quartz.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by zhaoyh on 2017/4/16.
 */
@Component
public class MyApplicationContext implements ApplicationContextAware {
   private static ApplicationContext appContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.appContext=applicationContext;
    }
    public static Object getBean(String paramString)
    {
        return appContext.getBean(paramString);
    }
}
