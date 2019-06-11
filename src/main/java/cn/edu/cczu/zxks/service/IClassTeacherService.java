package cn.edu.cczu.zxks.service;

import cn.edu.cczu.zxks.entity.Class;
import cn.edu.cczu.zxks.entity.ClassTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jjc
 * @since 2019-05-13
 */
public interface IClassTeacherService extends IService<ClassTeacher> {
    public List<Class> selecClassByteacher(Long teacherId);

}
