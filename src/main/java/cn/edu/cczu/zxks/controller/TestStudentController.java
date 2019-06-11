package cn.edu.cczu.zxks.controller;


import cn.edu.cczu.zxks.entity.Student;
import cn.edu.cczu.zxks.entity.Test;
import cn.edu.cczu.zxks.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jjc
 * @since 2019-05-21
 */
@Controller
@RequestMapping("/test-student")
public class TestStudentController {

    @Autowired
    private ITestService testService;

    @RequestMapping("/gostudenttest")
    public String gostudenttest(HttpSession session ,Model model){
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        String time=ft.format(dNow);
        Student student=(Student) session.getAttribute("student");
        Long studentId=student.getStudentId();

        List<Test> tesList =testService.selectTestList(studentId,time);
        model.addAttribute("tesList",tesList);

        return "studenttest";
    }

}
