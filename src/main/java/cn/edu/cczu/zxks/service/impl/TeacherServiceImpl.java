package cn.edu.cczu.zxks.service.impl;

import cn.edu.cczu.zxks.entity.Teacher;
import cn.edu.cczu.zxks.mapper.TeacherMapper;
import cn.edu.cczu.zxks.service.ITeacherService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jjc
 * @since 2019-05-13
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    public IPage<Teacher> selectList(Page<Teacher> page, @Param("teacher") Teacher teacher){
       return  teacherMapper.selectList(page,teacher);
    }
    public Teacher login(@Param("username")String username, @Param("password") String password){
        return teacherMapper.login(username,password);
    }

}
