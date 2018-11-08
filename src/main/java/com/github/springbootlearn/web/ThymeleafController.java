package com.github.springbootlearn.web;


import com.github.springbootlearn.model.Permission;
import com.github.springbootlearn.model.Student;
import com.github.springbootlearn.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 模板引擎控制器，web开发
 */
@Controller
@RequestMapping("/th")
public class ThymeleafController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/getStudentInfo")
    public String getStudentInfo(Model model){
        Student stu = new Student();
        stu.setName("jack");
        stu.setId(1);
        model.addAttribute("student", stu);
        return "index";
    }


    @RequestMapping("/getPermissionlist")
    public String getPermissionlist(Model model){
        List<Permission> permissionlist = permissionService.getPermissionlist();
        model.addAttribute(permissionlist);
        return "list";
    }


    @RequestMapping("/test")
    public String test(Model model){
        Student stu = new Student();
        stu.setName("jack");
        stu.setId(1);
        model.addAttribute("student", null);
        return "index";
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            if (i%10==0){
                System.out.println(i+":"+(char)i+",");
            }else{
                System.out.print(i+":"+(char)i+",");
            }
        }
    }

}
