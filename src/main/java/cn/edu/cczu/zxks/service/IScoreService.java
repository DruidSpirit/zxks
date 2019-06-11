package cn.edu.cczu.zxks.service;

import cn.edu.cczu.zxks.entity.Score;
import cn.edu.cczu.zxks.entity.ScorePram;
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
public interface IScoreService extends IService<Score> {
    public List<Score> selectScore(Long studentId);
    /**
     * 老师查看分数
     * */
    public IPage<Score> selectList(Page<Score> page, @Param("scorePram") ScorePram scorePram);

}
