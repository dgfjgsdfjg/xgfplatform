package com.cmpay.xgf.service;

import com.cmpay.lemon.common.exception.BusinessException;
import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.xgf.dao.IMenuDao;
import com.cmpay.xgf.dto.MenuInfoDTO;
import com.cmpay.xgf.entity.MenuDO;
import com.cmpay.xgf.entity.RoleMenuDO;
import com.cmpay.xgf.enums.MsgEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public List<MenuDO> find(MenuDO menuDO) {

        return menuDao.find(menuDO);
    }

    @Override
    public void checkMenu(RoleMenuDO roleMenuDO) {


    }

    public List selectAllMenu() {
        MenuDO tempMenuDO = new MenuDO();
        tempMenuDO.setIsUsed(1);
        List<MenuDO> menuList = menuDao.find(tempMenuDO);

        List<MenuInfoDTO> menuInfoDTOList = new ArrayList<>();
        for(MenuDO menuDO : menuList) {
            MenuInfoDTO menuInfoDTO = new MenuInfoDTO();
            BeanUtils.copy(menuInfoDTO,menuDO);
            menuInfoDTOList.add(menuInfoDTO);
        }

        return buildMenu(menuInfoDTOList,0);
    }

    public List<Map> buildMenu(List<MenuInfoDTO> menuList, Integer parentId) {

        List<Map> mapList = new ArrayList<>();
        for(MenuInfoDTO menu :menuList) {
            if(parentId.equals(menu.getParentId())) {

                Map map = new HashMap(10);
                map.put("id",menu.getMenuId());
                map.put("menuName",menu.getMenuName());
                map.put("menuType",menu.getType());
                map.put("authMark",menu.getOperate());
                map.put("pid",menu.getParentId());
                map.put("children",buildMenu(menuList,menu.getMenuId()));
                mapList.add(map);
            }
        }
        return mapList;
    }



}
