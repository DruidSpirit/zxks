package cn.edu.cczu.zxks.service.impl;

import cn.edu.cczu.zxks.entity.Student;
import cn.edu.cczu.zxks.mapper.StudentMapper;
import cn.edu.cczu.zxks.service.IStudentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jjc
 * @since 2019-05-09
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Resource
    private StudentMapper studentMapper;
    public IPage<Student> selectList(Page<Student> page, Student student){
       return  studentMapper.selectList(page,student);
    }

    public Student login(String username,String password){
        return studentMapper.login(username,password);
    }

    public List<Student> selecStuList(@Param("classId")Long classId){
        return studentMapper.selecStuList(classId);
    }

}
