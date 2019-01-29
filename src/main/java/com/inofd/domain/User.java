package com.inofd.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Getter
@Setter
@ToString
public class User {
    private Integer id;

    @NotNull(message = "用户名不能为空")
    @Size(min = 6,max = 12,message = "用户名设置至少6位,最大12位")
    private String username;
    @Size(min = 6,max = 12,message = "密码设置至少6位,最大12位")
    private String password;

    private String gender;
    @NotNull(message = "邮件不能为空!")
    @Email(message = "邮件格式不正确")
    private String email;

    private String telephone;

    private String introduce;

    private String activecode;

    private Integer state;

    private String role;

    private Date registtime;
}