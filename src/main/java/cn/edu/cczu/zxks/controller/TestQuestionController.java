package cn.edu.cczu.zxks.controller;


import cn.edu.cczu.zxks.entity.*;
import cn.edu.cczu.zxks.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jjc
 * @since 2019-05-15
 */
@Controller
@RequestMapping("/test-question")
public class TestQuestionController {

    @Autowired
    private ITestQuestionService testQuestionService;
    @Autowired
    private IExamService examService;

    @Autowired
    private IScoreService scoreService;
    @Autowired
    private ITestService testService;
    @Autowired
    private ITestStudentService testStudentService;

    @RequestMapping("/gostutestquestion")
    public String gostutestquestion(String id, Model model,HttpSession session){
        Student student=(Student) session.getAttribute("student");
        List<Question> queList= testQuestionService.selectoptList(Long.parseLong(id));
        List<Question> tianList=testQuestionService.selecttianList(Long.parseLong(id)) ;
        testStudentService.updateTesStu(student.getStudentId(), Long.parseLong(id));
        Test test=testService.selectById(Long.parseLong(id));
        Score score=new Score();
        score.setScoreScore(0);
        score.setScoreStudent(student.getStudentId());
        score.setScore_test(Long.parseLong(id));
        score.setScoreSubject(test.getTestSubject());
        scoreService.save(score);
        model.addAttribute("scoreId",score.getScoreId());
        model.addAttribute("testId",Long.parseLong(id));
        model.addAttribute("queList",queList);
        model.addAttribute("tianList",tianList);
        return "studenttestquestion";
    }
    @RequestMapping("panduan")
    public String panduan(String opt0,String opt1, String opt2, String opt3, String opt4, String opt5, String opt6,
                            String opt7, String opt8, String opt9,
                            String[] answer, Long testId , Long scoreId,HttpSession session){
        Student student=(Student) session.getAttribute("student");
        List<String> opt=new ArrayList<>();
        opt.add(opt0); opt.add(opt1); opt.add(opt2);opt.add(opt3);opt.add(opt4);
        opt.add(opt5); opt.add(opt6); opt.add(opt7); opt.add(opt8); opt.add(opt9);

        List<Question> queList= testQuestionService.selectoptList(testId);
        List<Question> tianList=testQuestionService.selecttianList(testId);
        int i=0;
        int sum=0;
        for(Question que:queList){
            Exam exam=new Exam();
            exam.setExamAnswer(opt.get(i));
            exam.setExamQuestion(que.getQuestionId());
            exam.setExamTest(testId);
            exam.setExamStudent(student.getStudentId());
            exam.setExamScore(5);
            if(que.getQuestionRealanswer().equals(opt.get(i))){
                exam.setExamScore(5);
                sum+=5;
            }else {
                exam.setExamScore(0);
            }
            examService.save(exam);
            i++;
        }
        int j=0;
        for(Question tque:tianList){
            Exam exam=new Exam();
            exam.setExamAnswer(answer[j]);
            exam.setExamQuestion(tque.getQuestionId());
            exam.setExamTest(testId);
            exam.setExamStudent(student.getStudentId());
            if(tque.getQuestionRealanswer().equals(answer[j])){
                exam.setExamScore(5);
                sum+=5;
            }else {
                exam.setExamScore(0);
            }
            examService.save(exam);
            j++;
        }
        /*Test test=testService.selectById(testId);
        Score score=new Score();
        System.out.println(sum+"...........");
        score.setScoreScore(sum);
        score.setScoreStudent(student.getStudentId());
        score.setScore_test(testId);

        score.setScoreSubject(test.getTestSubject());
        scoreService.save(score);*/
        Score score=new Score();
        score.setScoreId(scoreId);
        score.setScoreScore(sum);
        scoreService.updateById(score);
        return "redirect:/score/selectScore";
    }
}
