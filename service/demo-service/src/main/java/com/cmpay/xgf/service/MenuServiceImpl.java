package com.cmpay.xgf.service;

import com.cmpay.lemon.common.exception.BusinessException;
import com.cmpay.xgf.dao.IMenuDao;
import com.cmpay.xgf.entity.MenuDO;
import com.cmpay.xgf.entity.RoleMenuDO;
import com.cmpay.xgf.enums.MsgEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author xgf
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    IMenuDao menuDao;


    @Override
    public void createMenu(MenuDO menuDO) {

        int res = menuDao.insert(menuDO);

        if (res != 1) {
            BusinessException.throwBusinessException(MsgEnum.DB_INSERT_FAILED);
        }
    }

    @Override
    public void delete(MenuDO menuDO) {

        int res = menuDao.update(menuDO);

        if (res != 1) {
            BusinessException.throwBusinessException(MsgEnum.DB_UPDATE_FAILED);
        }
    }

    @Override
    public void checkMenu(RoleMenuDO roleMenuDO) {


    }
}
