package net.mengfan.fun.service.impl;

import net.mengfan.fun.dao.MenuMapper;
import net.mengfan.fun.domain.Menu;
import net.mengfan.fun.domain.MenuOption;
import net.mengfan.fun.service.MenuService;
import net.mengfan.fun.utils.MenuOptionTree;
import net.mengfan.fun.utils.MenuTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    private MenuMapper menuMapper;

    @Autowired
    public void MenuMapper(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public void insertMenu(Menu menu) {
        menuMapper.insertMenu(menu);
    }

    @Override
    public Integer selectMenuByName(String menuName) {
        return menuMapper.selectMenuByName(menuName);
    }

    @Override
    public List<MenuOption> getMenuOptionListTree() {
        List<MenuOption> menuOptionList = menuMapper.selectMenuListTree();
        MenuOptionTree menuOptionTree = new MenuOptionTree();
        List<MenuOption> menuOptionListTree = new ArrayList<MenuOption>();
        MenuOption menuOption = new MenuOption();
        menuOption.setLabel("顶级目录");
        menuOption.setValue(0);
        menuOptionListTree.add(menuOption);
        menuOptionListTree.addAll(menuOptionTree.buildTree(menuOptionList));
        return menuOptionListTree;
    }

    @Override
    public List<Menu> getMenuListTree() {
        List<Menu> menuList = menuMapper.selectMenuAll();
        MenuTree menuTree = new MenuTree();
        return menuTree.buildTree(menuList);
    }

    @Override
    public Integer selectMenuSubset(Integer MenuId) {
        return menuMapper.selectMenuSubset(MenuId);
    }

    @Override
    public void deleteMenu(Integer menuId) {
        menuMapper.deleteMenu(menuId);
    }


}
