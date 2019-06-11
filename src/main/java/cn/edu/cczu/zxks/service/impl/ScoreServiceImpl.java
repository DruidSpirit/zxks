package cn.edu.cczu.zxks.service.impl;

import cn.edu.cczu.zxks.entity.Score;
import cn.edu.cczu.zxks.entity.ScorePram;
import cn.edu.cczu.zxks.mapper.ScoreMapper;
import cn.edu.cczu.zxks.service.IScoreService;
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
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    public List<Score> selectScore(Long studentId){
        return scoreMapper.selectScore(studentId);
    }

    /**
     * 老师查看分数
     * */
    public IPage<Score> selectList(Page<Score> page, @Param("scorePram") ScorePram scorePram){
        return  scoreMapper.selectList(page,scorePram);
    }
}
