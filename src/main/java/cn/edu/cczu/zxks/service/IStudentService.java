package cn.edu.cczu.zxks.service;

import cn.edu.cczu.zxks.entity.Student;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jjc
 * @since 2019-05-09
 */
public interface IStudentService extends IService<Student> {

    public IPage<Student> selectList(Page<Student> page, Student student);
    public Student login(@Param("username")String username, @Param("password") String password);
    public List<Student> selecStuList(@Param("classId")Long classId);

}
