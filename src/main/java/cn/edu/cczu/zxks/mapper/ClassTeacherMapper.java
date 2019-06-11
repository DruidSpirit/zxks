package cn.edu.cczu.zxks.mapper;

import cn.edu.cczu.zxks.entity.Class;
import cn.edu.cczu.zxks.entity.ClassTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jjc
 * @since 2019-05-13
 */
public interface ClassTeacherMapper extends BaseMapper<ClassTeacher> {

    public List<Class> selecClassByteacher(@Param("teacherId") Long teacherId);

}
