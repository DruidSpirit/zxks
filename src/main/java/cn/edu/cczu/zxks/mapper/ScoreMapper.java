package cn.edu.cczu.zxks.mapper;

import cn.edu.cczu.zxks.entity.Score;
import cn.edu.cczu.zxks.entity.ScorePram;
import cn.edu.cczu.zxks.entity.Student;
import cn.edu.cczu.zxks.entity.Test;
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
public interface ScoreMapper extends BaseMapper<Score> {
    public List<Score> selectScore(@Param("studentId") Long studentId);

    /**
     * 老师查看分数
     * */
    public IPage<Score> selectList(Page<Score> page, @Param("scorePram") ScorePram scorePram);

}
