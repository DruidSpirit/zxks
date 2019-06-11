package cn.edu.cczu.zxks.service;

import cn.edu.cczu.zxks.entity.Teacher;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jjc
 * @since 2019-05-13
 */
public interface ITeacherService extends IService<Teacher> {

    public IPage<Teacher> selectList(Page<Teacher> page, Teacher teacher);
    public Teacher login(@Param("username")String username, @Param("password") String password);

}
