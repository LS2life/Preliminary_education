package io.github.ls2life;

import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.mbeans.UserMBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {
    
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println("초기화 완료!!");

        UserBean userBean = (UserMBean)ac.getBean("userBean");
    }
}
