package cn.edu.cczu.zxks.controller;


import cn.edu.cczu.zxks.entity.Student;
import cn.edu.cczu.zxks.entity.Teacher;
import cn.edu.cczu.zxks.service.ISubjectService;
import cn.edu.cczu.zxks.service.ITeacherService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jjc
 * @since 2019-05-13
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    @Autowired
    private ISubjectService subjectService;

    @RequestMapping("/selectList")
    private String goteacher(@RequestParam(value = "current",defaultValue = "1",required = false)Integer current,
                             @RequestParam(value = "pageSize",defaultValue = "2",required = false)Integer pageSize,
                             Teacher teacher, Model model){

        if("null".equals(teacher.getTeacherRealname())){
            teacher.setTeacherRealname(null);
        }
        if("null".equals(teacher.getTeacherSubject())){
            teacher.setTeacherSubject(0L);
        }if("null".equals(teacher.getTeacherAccount())){
            teacher.setTeacherAccount(null);
        }

        List subList=subjectService.list();

        Page page=new Page<>(current,pageSize);
        IPage<Teacher> teacherList= teacherService.selectList(page,teacher);
        model.addAttribute("teacherList",teacherList);
        model.addAttribute("current",current);

        model.addAttribute("teacher",teacher);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("subList",subList);
        return "teacher";

    }


    @RequestMapping("/insert")
    public String goaddteacher(Model model){
        List list=subjectService.list();
        model.addAttribute("subList",list);
        return "addteacher";
    }
    @RequestMapping("/insertload")
    public String inserttea(Teacher teacher){
        teacher.setTeacherPassword("123456");
        teacher.setTeacherState(0);
        teacherService.save(teacher);
        return "redirect:/teacher/selectList";
    }

    @RequestMapping("/deleteTea")
    public String deleteById(@RequestParam("id") String id, Teacher teacher, Integer current, RedirectAttributes model){
        Teacher tea=new Teacher();
        tea.setTeacherState(1);
        tea.setTeacherId(Long.parseLong(id));
        teacherService.updateById(tea);
        model.addAttribute("current",current);
        model.addAttribute("teacherAccount",teacher.getTeacherAccount());
        model.addAttribute("teacherRealname",teacher.getTeacherRealname());
        model.addAttribute("teacherSubject",teacher.getTeacherSubject());
        return "redirect:/teacher/selectList";
    }

    @RequestMapping("/updateTea")
    public String updateStu(@RequestParam("id") String id,Teacher teacher,Integer current,Model model){
        List list=subjectService.list();
        Long teaId=Long.parseLong(id);
        Teacher teacher1=teacherService.getById(teaId);
        model.addAttribute("tea",teacher1);
        model.addAttribute("subList",list);

        model.addAttribute("current",current);
        model.addAttribute("Account",teacher.getTeacherAccount());
        model.addAttribute("Realname",teacher.getTeacherRealname());
        model.addAttribute("Subject",teacher.getTeacherSubject());

        return "updateteacher";
    }

    @RequestMapping("/updateTeaBefor")
    public String updateStuBefor(Teacher teacher,Integer current,RedirectAttributes model,String Account,String Realname,String Subject){
        Long subjectId=0L;
        if(!"null".equals(Subject)&&null!=Subject){
            subjectId=Long.parseLong(Subject);
        }



       /* Teacher teacher1=new Teacher();
        teacher1.setTeacherAccount(Account);
        teacher1.setTeacherSubject(subjectId);
        teacher1.setTeacherRealname(Realname);*/

        teacherService.updateById(teacher);

        model.addAttribute("current",current);
        model.addAttribute("teacherAccount",Account);
        model.addAttribute("teacherRealname",Realname);
        model.addAttribute("teacherSubject",Subject);
        return "redirect:/teacher/selectList";
    }
    @RequestMapping("/updatePwd")
    public  String updatePwd(HttpSession session,Model model){
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        model.addAttribute("teacher",teacher);
        return "updatepwdtea";
    }
    @RequestMapping("/updatePwdAfter")
    public String updatePwdAfter(Teacher teacher,Model model){
        teacherService.updateById(teacher);

        return "redirect:/login/logout";
    }





}
