package net.mengfan.fun.controller;

import net.mengfan.fun.common.result.Result;
import net.mengfan.fun.common.result.ResultCode;
import net.mengfan.fun.dao.MenuMapper;
import net.mengfan.fun.domain.Menu;
import net.mengfan.fun.service.MenuService;
import net.mengfan.fun.service.impl.MenuServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    private Menu menu;

    @Autowired
    public void Menu(Menu menu) {
        this.menu = menu;
    }

    private MenuService menuService;

    @Autowired
    public void MenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping("add")
    public Result addMenu(@RequestBody Menu menu) {
        logger.info(menu.toString());
        if (menuService.selectMenuByName(menu.getMenuName()) != 0) {
            return Result.failure(ResultCode.MENU_ALREADY_EXISTS);
        }
        if (menu.getParentMenu().equals("根菜单")) {
            menu.setParentMenu("0");
        }
        menuService.insertMenu(menu);
        return Result.success();
    }

}
