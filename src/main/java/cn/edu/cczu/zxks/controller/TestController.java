package cn.edu.cczu.zxks.controller;


import cn.edu.cczu.zxks.entity.*;
import cn.edu.cczu.zxks.entity.Class;
import cn.edu.cczu.zxks.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService testService;
    @Autowired
    private IClassService classService;
    @Autowired
    private IClassTeacherService classTeacherService;
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private ITestQuestionService testQuestionService;
    @Autowired
    private IQuestionService questionService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private ITestStudentService testStudentService;



    /**
     * 添加
     * */
    @RequestMapping("/insert")
    public String insert(Model model , HttpSession session){
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        List classList=classTeacherService.selecClassByteacher(teacher.getTeacherId());//session.teacher id
        model.addAttribute("classList",classList);
        return  "addtest";
    }
    @RequestMapping("insertload")
    public String insertload(@RequestParam(value = "pageSize1" ,defaultValue = "10",required = false) Integer pageSize1,
                             @RequestParam(value = "pageSize2" ,defaultValue = "10",required = false) Integer pageSize2,
                             Test test,HttpSession session){
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        test.setTestState(0);
        test.setTestSubject(teacherService.getById(teacher.getTeacherId()).getTeacherSubject());//session.teacher id
        test.setTestTeacher(teacher.getTeacherId());//session.teacher id
        testService.save(test);
        System.out.println(test.getTestClass());

        List list=new ArrayList();

        List<Question> questions=questionService.selectXuanZe(pageSize1,test.getTestSubject());
        List<Question> tkList=questionService.selectTianKong(pageSize2,test.getTestSubject());
        List<Student> studentList=studentService.selecStuList(test.getTestClass());

        for (Student student : studentList){
            TestStudent  testStudent=new TestStudent();
            testStudent.setStudentId(student.getStudentId());
            testStudent.setTestId(test.getTestId());
            testStudent.setTestStudentState(0);
            testStudentService.save(testStudent);
        }

        for (Question question : questions){
            TestQuestion  testQuestion=new TestQuestion();
            testQuestion.setQuestionId(question.getQuestionId());
            testQuestion.setTestId(test.getTestId());
            testQuestion.setTestQuestionState(0);
            testQuestion.setQuestionSorce(5);
            testQuestionService.save(testQuestion);
        }
        for (Question tiankong : tkList){
            TestQuestion  testQuestion=new TestQuestion();
            testQuestion.setQuestionId(tiankong.getQuestionId());
            testQuestion.setTestId(test.getTestId());
            testQuestion.setTestQuestionState(0);
            testQuestion.setQuestionSorce(5);
            testQuestionService.save(testQuestion);
        }
        return "redirect:/test/selectList";
    }

    @RequestMapping("/selectList")
    public String selectList(@RequestParam(value = "current",defaultValue = "1",required = false)Integer current,
                             @RequestParam(value = "pageSize",defaultValue = "3",required = false)Integer pageSize,
                             Test test, Model model,HttpSession session){
        if("null".equals(test.getTestTitle())){
            test.setTestTitle(null);
        }
        if("null".equals(test.getTestClass())){
            test.setTestClass(0L);
        }if("null".equals(test.getTestStarttime())){
            test.setTestStarttime(null);
        }
        Teacher teacher=(Teacher) session.getAttribute("teacher");

        List classList=classTeacherService.selecClassByteacher(teacher.getTeacherId());//session.teacher.id

        Page page=new Page<>(current,pageSize);

        test.setTestTeacher(teacher.getTeacherId());//session.teacher.id
        IPage tesList= testService.selectList(page,test);
        model.addAttribute("tesList",tesList);
        model.addAttribute("current",current);

        model.addAttribute("test",test);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("classList",classList);

        return "test";
    }

    /**
     * 删除by Id
     * @param id
     * */
    @RequestMapping("/deleteTes")
    public String deleteById(@RequestParam("id") String id,Test test,Integer current,RedirectAttributes model){
        Test tes=new Test();
        tes.setTestState(1);
        tes.setTestId(Long.parseLong(id));
        testService.updateById(tes);
        model.addAttribute("current",current);
        model.addAttribute("testTitle",test.getTestTitle());
        model.addAttribute("testStarttime",test.getTestStarttime());
        model.addAttribute("testClass",test.getTestClass());
        return "redirect:/test/selectList";
    }
    /**
     * 去修改页面
     * */
    @RequestMapping("/updateTes")
    public String updateTes(@RequestParam("id") String id,Test test,Integer current,Model model,HttpSession session){
        Teacher teacher=(Teacher) session.getAttribute("teacher");

        List classList=classTeacherService.selecClassByteacher(teacher.getTeacherId());//session.teacher.id
        Test test1=testService.selectById(Long.parseLong(id));
        model.addAttribute("tes",test1);
        model.addAttribute("classList",classList);

        model.addAttribute("current",current);
        model.addAttribute("Starttime",test.getTestStarttime());
        model.addAttribute("Title",test.getTestTitle());
        model.addAttribute("Class",test.getTestClass());
        return "updatetest";
    }

    @RequestMapping("/updateTesBefor")
    public String updateStuBefor(Test test,Integer current,RedirectAttributes model,String Starttime,String Title,String Class){
         testService.updateById(test);
        model.addAttribute("current",current);
        model.addAttribute("testTitle",Title);
        model.addAttribute("testStarttime",Starttime);
        model.addAttribute("testClass",Class);
        return "redirect:/test/selectList";
    }




}
