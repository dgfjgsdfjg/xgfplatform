package com.cmpay.xgf.service;

import com.cmpay.xgf.dao.IUserDao;
import com.cmpay.xgf.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xgf
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    IUserDao userDao;

    @Override
    public int regist(UserDO userDO) {

        return userDao.insert(userDO);

    }

    @Override
    public List<UserDO> findUsers(UserDO userDO) {

        return userDao.find(userDO);
    }

    @Override
    public int delete(UserDO userDO) {

        return userDao.update(userDO);
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
