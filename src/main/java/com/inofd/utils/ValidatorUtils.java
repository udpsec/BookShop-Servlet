package com.inofd.utils;

import com.inofd.exception.RRException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * hibernate-validator校验工具类,springboot-web的start会自动导入校验工具类所需要的包
 */
public class ValidatorUtils {

    // 声明一个静态的validator
    private static Validator validator;

    // 在静态代码块中实例化validator
    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     * @param object 待校验对象
     * @param groups 待校验的组
     * @throws RRException 校验不通过,则报RRException异常
     */
    public static void validateEntity(Object object, Class<?>...groups){
        // 校验
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object,groups);
        // 如果constraintViolations不为空的话,证明校验的属性有未通过的
        if (!constraintViolations.isEmpty()){
            // 实例化一个StringBuilder来存放校验报错信息
            StringBuilder msg = new StringBuilder();
            // 遍历constraintViolations取到报错信息
            for (ConstraintViolation<Object> constraint : constraintViolations){
                // 将报错信息封入msg
                msg.append(constraint.getMessage()).append("<br>");
            }
            // 抛出异常
            throw new RRException(msg.toString());
        }
    }
}
