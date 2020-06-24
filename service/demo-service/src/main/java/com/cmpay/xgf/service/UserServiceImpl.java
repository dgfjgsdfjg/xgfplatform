package com.cmpay.xgf.service;

import com.cmpay.lemon.common.exception.BusinessException;
import com.cmpay.xgf.dao.IUserDao;
import com.cmpay.xgf.entity.UserDO;
import com.cmpay.xgf.enums.MsgEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xgf
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    IUserDao userDao;

    @Override
    public void regist(UserDO userDO) {

        int res =  userDao.insert(userDO);

        if (res != 1) {
            BusinessException.throwBusinessException(MsgEnum.DB_INSERT_FAILED);
        }

    }

    @Override
    public List<UserDO> findUsers(UserDO userDO) {

        return userDao.find(userDO);
    }

    @Override
    public void delete(UserDO userDO) {

        int res = userDao.update(userDO);

        if (res != 1) {
            BusinessException.throwBusinessException(MsgEnum.DB_UPDATE_FAILED);
        }
    }

    @Override
    public List<UserDO> pageFindUsers(UserDO userDO) {

        return userDao.find(userDO);
    }


//    /**
//     * 分页查询
//     */
//    @Override
//    public PageInfo<UserDO> findUsers(UserInfoQueryBO queryBO) {
//        UserDO userDO = new UserDO();
//        BeanUtils.copyProperties(userDO, queryBO);
//        return PageUtils.pageQueryWithCount(queryBO.getPageNum(), queryBO.getPageSize(), () -> userDao.find(userDO));
//    }


}
