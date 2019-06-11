package cn.edu.cczu.zxks.service.impl;

import cn.edu.cczu.zxks.entity.Class;
import cn.edu.cczu.zxks.entity.ClassTeacher;
import cn.edu.cczu.zxks.mapper.ClassTeacherMapper;
import cn.edu.cczu.zxks.service.IClassTeacherService;
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
 * @since 2019-05-13
 */
@Service
public class ClassTeacherServiceImpl extends ServiceImpl<ClassTeacherMapper, ClassTeacher> implements IClassTeacherService {

    @Resource
    private ClassTeacherMapper classTeacherMapper;
    public List<Class> selecClassByteacher(Long  teacherId){
        return classTeacherMapper.selecClassByteacher(teacherId);
    }

}
