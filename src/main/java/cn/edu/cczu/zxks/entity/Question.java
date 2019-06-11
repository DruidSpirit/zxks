package cn.edu.cczu.zxks.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2019-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_question")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 问题ID
     */
    @TableId(value = "question_id", type = IdType.AUTO)
    private Long questionId;

    /**
     * 试题题目
     */
    @TableField("question_name")
    private String questionName;

    /**
     * 试题选项A
     */
    @TableField("question_option_a")
    private String questionOptionA;

    /**
     * 试题选项B
     */
    @TableField("question_option_b")
    private String questionOptionB;

    /**
     * 试题选项C
     */
    @TableField("question_option_c")
    private String questionOptionC;

    /**
     * 试题选项D
     */
    @TableField("question_option_d")
    private String questionOptionD;

    /**
     * 试题答案
     */
    @TableField("question_realanswer")
    private String questionRealanswer;

    /**
     * 试题类型
     */
    @TableField("question_type")
    private Integer questionType;

    /**
     * 学科ID外键
     */
    @TableField("question_subject")
    private Long questionSubject;

    /**
     * 试题状态
     */
    @TableField("question_state")
    private Integer questionState;



}
