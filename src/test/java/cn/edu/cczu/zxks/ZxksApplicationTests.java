package cn.edu.cczu.zxks;

import cn.edu.cczu.zxks.entity.*;
import cn.edu.cczu.zxks.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZxksApplicationTests {

    @Resource
    private IStudentService studentService;
    @Resource
    private ITeacherService teacherService;
    @Resource
    private IClassTeacherService classTeacherService;
    @Resource
    private IQuestionService questionService;

    @Resource
    private ITestQuestionService testQuestionService;
    @Resource
    private ITestService testService;
    @Resource
    private IExamService examService;
    @Resource
    private IScoreService scoreService;






    @Test
    public void contextLoads() {
       /*IPage stu=studentService.page(new Page<>(1,2),new QueryWrapper<>());
       Object object=stu;*/

/*       Page<Student> page=new Page<Student>(1,2);
       IPage<Student> page1=studentService.selectList(page,new Student());
       Object object=page1;*/

/*
        Page<Teacher> page=new Page<>(1,2);
        IPage page1=teacherService.selectList(page,new Teacher());
*/
//       List classLis= classTeacherService.selecClassByteacher(1L);
/*
        List<Question> questionList=questionService.selectTianKong(10,1L);

        for (Question question : questionList){
            TestQuestion testQuestion=new TestQuestion();
            testQuestion.setQuestionId(question.getQuestionId());
            testQuestion.setTestId(1L);
            testQuestion.setTestQuestionState(0);
            testQuestion.setQuestionSorce(5);
            testQuestionService.save(testQuestion);
        }
*/
/*        cn.edu.cczu.zxks.entity.Test test1=new cn.edu.cczu.zxks.entity.Test();
        test1.setTestTeacher(1l);



        IPage list= testService.selectList(new Page<cn.edu.cczu.zxks.entity.Test>(1,10),test1);*/
//        cn.edu.cczu.zxks.entity.Test test=testService.selectById(1l);
/*
        String username="180254";
        String password="123456";
//        Student student=studentService.login(username,password);
        Teacher teacher =teacherService.login(username,password);
*/

//        Student student= studentService.getOne(new QueryWrapper<Student>().eq("student_account",username).eq("student_password",password));
/*        Long studentId=1L;
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        String time=ft.format(dNow);
        List<cn.edu.cczu.zxks.entity.Test> testList= testService.selectTestList(studentId,time);*/
//        List<Question> queList=testQuestionService.selectoptList(18L);
/*        Exam exam=new Exam();
        exam.setExamScore(5);
        exam.setExamStudent(1L);
        exam.setExamTest(2L);
        exam.setExamQuestion(1L);
        exam.setExamAnswer("D");

        examService.save(exam);*/

//        List<Score> stuScore= scoreService.selectScore(2L);
        ScorePram scorePram=new ScorePram();
        scorePram.setTeacherId(1L);
        scorePram.setTeacherSubject(1L);
        IPage page1=scoreService.selectList(new Page<Score>(1,2),scorePram );
        Object a=new Object();








    }

}
