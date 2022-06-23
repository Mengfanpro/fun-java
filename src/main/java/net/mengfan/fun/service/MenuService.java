package net.mengfan.fun.service;

import net.mengfan.fun.domain.Menu;
import net.mengfan.fun.domain.MenuOption;

import java.util.List;


public interface MenuService {


    Integer insertMenu(Menu menu);

    Integer selectMenuByName(String menuName);

    List<MenuOption> getMenuOptionListTree();

    List<Menu> getMenuListTree();
}
