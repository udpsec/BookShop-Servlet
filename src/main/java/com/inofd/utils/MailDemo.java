package com.inofd.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.Mail;
import cn.hutool.extra.mail.MailUtil;

public class MailDemo {
    public static void main(String[] args) {
        MailUtil.send("629460186@qq.com", "测试1", "<h1>邮件来自inofd测试</h1>", true, FileUtil.file("d:/aaa.xml"));
    }
}
