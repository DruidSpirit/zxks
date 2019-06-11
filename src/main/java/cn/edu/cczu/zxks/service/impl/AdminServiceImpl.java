package cn.edu.cczu.zxks.service.impl;

import cn.edu.cczu.zxks.entity.Admin;
import cn.edu.cczu.zxks.mapper.AdminMapper;
import cn.edu.cczu.zxks.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jjc
 * @since 2019-05-09
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
