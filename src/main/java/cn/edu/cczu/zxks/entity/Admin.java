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
@TableName("tb_admin")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员ID
     */
    @TableId(value = "admin_id", type = IdType.AUTO)
    private Long adminId;

    /**
     * 管理员账号
     */
    @TableField("admin_account")
    private String adminAccount;

    /**
     * 管理员密码
     */
    @TableField("admin_password")
    private String adminPassword;

    /**
     * 电话
     */
    @TableField("admin_phone")
    private String adminPhone;

    /**
     * 状态
     */
    @TableField("admin_state")
    private String adminState;

    /**
     * 状态
     */
    @TableField("admin_realname")
    private String adminRealname;



}
