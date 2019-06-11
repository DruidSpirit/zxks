package cn.edu.cczu.zxks.controller;


import cn.edu.cczu.zxks.entity.Admin;
import cn.edu.cczu.zxks.entity.Student;
import cn.edu.cczu.zxks.entity.Teacher;
import cn.edu.cczu.zxks.service.IClassService;
import cn.edu.cczu.zxks.service.IStudentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jjc
 * @since 2019-05-09
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassService classService;

/*    @RequestMapping("/student")
    public String goStudent( @RequestParam(value = "current",defaultValue = "1",required = false)Integer current,
                             @RequestParam(value = "pageSize",defaultValue = "2",required = false)Integer pageSize,
                             Student student,Model model
                             ){
        System.out.println(student.getStudentRealname());
        if(student ==null){
            student=new Student();
        }
        QueryWrapper<Student> queryWrapper=new QueryWrapper<Student>()
                .eq(student.getStudentAccount()!=null&&!"null".equals(student.getStudentAccount()),"student_account",student.getStudentAccount())
                .like(student.getStudentRealname()!=null&&!"null".equals(student.getStudentRealname()),"student_realname",student.getStudentRealname())
                .eq(student.getStudentClass()!=null&&!"null".equals(student.getStudentClass()),"student_class",student.getStudentClass())
                .eq("student_state",0);
        Page page=new Page<>(current,pageSize);

        IPage stuList= studentService.page(page,queryWrapper);
        model.addAttribute("stuList",stuList);
        model.addAttribute("current",current);

//        System.out.println(student.getStudentRealname());

        model.addAttribute("student",student);
        model.addAttribute("pageSize",pageSize);

        return "student";
    }*/
    @RequestMapping("/selectList")
    public String selectList(@RequestParam(value = "current",defaultValue = "1",required = false)Integer current,
                             @RequestParam(value = "pageSize",defaultValue = "2",required = false)Integer pageSize,
                             Student student,Model model){
        if("null".equals(student.getStudentRealname())){
            student.setStudentRealname(null);
        }
        if("null".equals(student.getStudentClass())){
            student.setStudentClass(0L);
        }if("null".equals(student.getStudentAccount())){
            student.setStudentAccount(null);
        }

            List classList=classService.list();

        Page page=new Page<>(current,pageSize);
        IPage stuList= studentService.selectList(page,student);
        model.addAttribute("stuList",stuList);
        model.addAttribute("current",current);

        model.addAttribute("student",student);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("classList",classList);

        return "student";
    }
    /**
     * 删除by Id
     * @param id
     * */
    @RequestMapping("/deleteStu")
    public String deleteById(@RequestParam("id") String id,Student student,Integer current,RedirectAttributes model){
        Student stu=new Student();
        stu.setStudentState(1);
        stu.setStudentId(Long.parseLong(id));
        studentService.updateById(stu);
        model.addAttribute("current",current);
        model.addAttribute("studentAccount",student.getStudentAccount());
        model.addAttribute("studentRealname",student.getStudentRealname());
        model.addAttribute("studentClass",student.getStudentClass());
        return "redirect:/student/selectList";
    }

    @RequestMapping("/updateStu")
    public String updateStu(@RequestParam("id") String id,Student student,Integer current,Model model){
        List classList=classService.list();
        Long stuId=Long.parseLong(id);
        Student student1=studentService.getById(stuId);
        model.addAttribute("stu",student1);
        model.addAttribute("classList",classList);
        System.out.println(current+"updateStu...............................................");

        model.addAttribute("current",current);
        model.addAttribute("Account",student.getStudentAccount());
        model.addAttribute("Realname",student.getStudentRealname());
        model.addAttribute("Class",student.getStudentClass());
        return "updatestudent";
    }

    @RequestMapping("/updateStuBefor")
    public String updateStuBefor(Student student,Integer current,RedirectAttributes model,String Account,String Realname,String Class){
        Long classId=0L;
        if(!"null".equals(Class)&&null!=Class){
            classId=Long.parseLong(Class);
        }


       /* Student student1=new Student();
        student1.setStudentAccount(Account);
        student1.setStudentRealname(Realname);
        student1.setStudentClass(classId);*/

        studentService.updateById(student);
        model.addAttribute("current",current);
        model.addAttribute("studentAccount",Account);
        model.addAttribute("studentRealname",Realname);
        model.addAttribute("studentClass",Class);
        return "redirect:/student/selectList";
    }

    /**
     * 添加
     * */
    @RequestMapping("/insert")
    public String insert(Model model){
        List classList=classService.list();
        model.addAttribute("classList",classList);
        return  "addstudent";
    }
    @RequestMapping("insertload")
    public String insertload(Student student){
        student.setStudentState(0);
        student.setStudentPassword("123456");
        studentService.save(student);
        return "redirect:/student/selectList";
    }

    @RequestMapping("/updatePwd")
    public  String updatePwd(HttpSession session, Model model){
        Student student=(Student) session.getAttribute("student");
        model.addAttribute("student",student);
        return "updatepwdtea";
    }
    @RequestMapping("/updatePwdAfter")
    public String updatePwdAfter(Student student,Model model){
        studentService.updateById(student);

        return "redirect:/login/logout";
    }
    @RequestMapping("/goqiantai")
    public String goqiantai(HttpSession session,Model model){
        Student student=(Student) session.getAttribute("student");
        model.addAttribute("student",student);
        return "studenttest";
    }

}
