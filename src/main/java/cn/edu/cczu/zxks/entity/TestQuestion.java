package cn.edu.cczu.zxks.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jjc
 * @since 2019-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_test_question")
public class TestQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    /**
     * 试卷ID
     */
    @TableField("test_id")
    private Long testId;

    /**
     * 问题ID
     */
    @TableField("question_id")
    private Long questionId;

    /**
     * 问题分数
     */
    @TableField("question_sorce")
    private Integer questionSorce;

    @TableField("test_question_state")
    private Integer testQuestionState;


}
