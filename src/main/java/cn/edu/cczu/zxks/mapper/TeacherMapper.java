package cn.edu.cczu.zxks.mapper;

import cn.edu.cczu.zxks.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jjc
 * @since 2019-05-13
 */
public interface TeacherMapper extends BaseMapper<Teacher> {

    public IPage<Teacher> selectList(Page<Teacher> page, @Param("teacher") Teacher teacher);
    public Teacher login(@Param("username")String username, @Param("password") String password);

}
