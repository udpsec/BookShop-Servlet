package com.inofd.utils;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class TestVerify {

    @Test
    public void TestVeri(){
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(100,40,5,120);
        String code = lineCaptcha.getCode();
        BufferedImage image = lineCaptcha.getImage();
        try {
            ImageIO.write(image,"jpeg", new File("D:\\1.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(code);
    }

}
