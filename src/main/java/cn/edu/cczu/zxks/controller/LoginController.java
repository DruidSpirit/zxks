package cn.edu.cczu.zxks.controller;

import cn.edu.cczu.zxks.constant.Msg;
import cn.edu.cczu.zxks.entity.Admin;
import cn.edu.cczu.zxks.entity.Student;
import cn.edu.cczu.zxks.entity.Teacher;
import cn.edu.cczu.zxks.service.IAdminService;
import cn.edu.cczu.zxks.service.IStudentService;
import cn.edu.cczu.zxks.service.ITeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @创建人 jjc
 * @创建时间 2019/5/17
 * @描述
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IAdminService adminService;

    @RequestMapping("/gologin")
    public String goLogin(){
        return "login";
    }
    @RequestMapping("/loginafter")
    @ResponseBody
    public Msg loginafter(@RequestParam("username") String username, @RequestParam("password")String password
            ,@RequestParam("type") String type, HttpSession session){
        if("1".equals(type)){
           Admin admin= adminService.getOne(new QueryWrapper<Admin>().eq("admin_account",username)
                   .eq("admin_password",password)
                   .eq("admin_state", 0)
           );
           if(admin==null||"".equals(admin)){
               return Msg.FAIL();
           }else {
               session.setAttribute("type",type);
               session.setAttribute("admin",admin);
               return Msg.SUCCESS().addAttribute("type",type);
           }

        }
        if("2".equals(type)){
            Teacher teacher= teacherService.login(username,password);
            if(teacher==null||"".equals(teacher)){
                return Msg.FAIL();
            }else {
                session.setAttribute("type",type);
                session.setAttribute("teacher",teacher);
                return Msg.SUCCESS().addAttribute("type",type);
            }

        }

        if("3".equals(type)){
            Student student= studentService.login(username,password);
            if(student==null||"".equals(student)){
                return Msg.FAIL();
            }else {
                session.setAttribute("type",type);
                session.setAttribute("student",student);
                return Msg.SUCCESS().addAttribute("type",type);
            }

        }
        return Msg.FAIL();
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("admin");
        session.removeAttribute("teacher");
        session.removeAttribute("student");
        session.removeAttribute("type");
        return "redirect:/login/gologin";
    }

}
