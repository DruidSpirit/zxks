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
@TableName("tb_subject")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学科ID
     */
    @TableId(value = "subject_id", type = IdType.AUTO)
    private Long subjectId;

    /**
     * 学科名字
     */
    @TableField("subject_name")
    private String subjectName;


}
