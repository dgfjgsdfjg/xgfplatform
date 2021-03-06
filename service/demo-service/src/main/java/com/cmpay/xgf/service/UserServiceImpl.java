package com.cmpay.xgf.service;

import com.cmpay.lemon.common.exception.BusinessException;
import com.cmpay.lemon.framework.security.SecurityUtils;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.xgf.dao.IUserDao;
import com.cmpay.xgf.dao.IUserRoleDao;
import com.cmpay.xgf.entity.UserDO;
import com.cmpay.xgf.entity.UserRoleDO;
import com.cmpay.xgf.enums.MsgEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xgf
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

    @Autowired
    IUserDao userDao;

    @Autowired
    IUserRoleDao userRoleDao;

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

    @Override
    public void insertRole(int uId, int userRoleId,int roleId) {

        List<UserRoleDO> userRoleDOList = new LinkedList<UserRoleDO>();

        UserRoleDO userRoleDO = new UserRoleDO();

        userRoleDO.setId(userRoleId);

        userRoleDO.setuId(uId);

        userRoleDO.setRoleId(roleId);

        userRoleDO.setCreateBy(SecurityUtils.getLoginName());
        userRoleDO.setCreateDate(LocalDateTime.now().toString());
        userRoleDO.setUpdateBy(SecurityUtils.getLoginName());
        userRoleDO.setUpdateDate(LocalDateTime.now().toString());
        userRoleDO.setIsUsed(1);

        userRoleDOList.add(userRoleDO);


        int res = userRoleDao.insertRole(userRoleDOList);

        if (res != 1) {
            BusinessException.throwBusinessException(MsgEnum.DB_INSERT_FAILED);
        }

    }

    @Override
    public void updateRole(int uId,int roleId) {

        UserRoleDO userRoleDO = new UserRoleDO();

        userRoleDO.setuId(uId);

        userRoleDO.setRoleId(roleId);

        userRoleDO.setUpdateBy(SecurityUtils.getLoginName());
        userRoleDO.setUpdateDate(LocalDateTime.now().toString());
        userRoleDO.setIsUsed(1);

        int res = userRoleDao.update(userRoleDO);

        if (res != 1) {
            BusinessException.throwBusinessException(MsgEnum.DB_UPDATE_FAILED);
        }
    }

    @Override
    public UserDO get(int uId) {

        return userDao.get(uId);
    }

    @Override
    public void update(UserDO userDO) {

        int res = userDao.update(userDO);

        if (res != 1) {
            BusinessException.throwBusinessException(MsgEnum.DB_UPDATE_FAILED);
        }
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
