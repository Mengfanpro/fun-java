package net.mengfan.fun.service;

import net.mengfan.fun.domain.Menu;


public interface MenuService {


    Integer insertMenu(Menu menu);

    Integer selectMenuByName(String menuName);
}
