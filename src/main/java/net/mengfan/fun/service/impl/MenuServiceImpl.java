package net.mengfan.fun.service.impl;

import net.mengfan.fun.dao.MenuMapper;
import net.mengfan.fun.domain.Menu;
import net.mengfan.fun.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    private MenuMapper menuMapper;

    @Autowired
    public void MenuMapper(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public Integer insertMenu(Menu menu) {
        return menuMapper.insertMenu(menu);
    }

    @Override
    public Integer selectMenuByName(String menuName) {
        return menuMapper.selectMenuByName(menuName);
    }


}
