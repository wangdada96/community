package com.zhisheng.community;

import com.zhisheng.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
public class MailTests {
    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail(){
        mailClient.senMail("1943985935@qq.com","Test","Hello ZhiShengWang");
    }

    @Test
    public void testHtmlMail(){
        Context context = new Context();
        context.setVariable("username","zhisheng");
        String content = templateEngine.process("/mail/demo",context);

        System.out.println(content);
        mailClient.senMail("1943985935@qq.com","hello",content);
    }
}
