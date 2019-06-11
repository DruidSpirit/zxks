package cn.edu.cczu.zxks.mapper;

import cn.edu.cczu.zxks.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jjc
 * @since 2019-05-09
 */
public interface StudentMapper extends BaseMapper<Student> {

    public IPage<Student> selectList(Page<Student> page, @Param("student") Student student);

    public Student login(@Param("username")String username,@Param("password") String password);
    public List<Student> selecStuList(@Param("classId")Long classId);

}
