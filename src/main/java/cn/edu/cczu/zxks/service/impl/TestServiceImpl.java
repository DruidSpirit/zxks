package cn.edu.cczu.zxks.service.impl;

import cn.edu.cczu.zxks.entity.Test;
import cn.edu.cczu.zxks.mapper.TestMapper;
import cn.edu.cczu.zxks.service.ITestService;
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
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {
    @Resource
    private TestMapper testMapper;
    public IPage<Test> selectList(Page<Test> page, @Param("test") Test test){
        return testMapper.selectList(page,test);
    }
    public Test selectById(@Param("id") Long id){
        return testMapper.selectById(id);
    }
    public List<Test> selectTestList(@Param("id")Long studentId,@Param("time")String time){
       return  testMapper.selectTestList(studentId,time);
    }

}
