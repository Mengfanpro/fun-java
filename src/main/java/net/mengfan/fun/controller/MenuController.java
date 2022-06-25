package net.mengfan.fun.controller;

import net.mengfan.fun.common.result.Result;
import net.mengfan.fun.common.result.ResultCode;
import net.mengfan.fun.domain.Menu;
import net.mengfan.fun.domain.MenuOption;
import net.mengfan.fun.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    private MenuService menuService;

    @Autowired
    public void MenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping("add")
    public Result addMenu(@RequestBody Menu menu) {
        if (menuService.selectMenuByName(menu.getMenuName()) != 0) {
            return Result.failure(ResultCode.MENU_ALREADY_EXISTS);
        }
        menuService.insertMenu(menu);
        return Result.success();
    }

    @RequestMapping("list/option/tree")
    public Result getMenuOptionListTree() {
        List<MenuOption> menuOptionList = menuService.getMenuOptionListTree();
        return Result.success(menuOptionList);
    }

    @RequestMapping("list/tree")
    public Result getMenuListTree() {
        List<Menu> menuList = menuService.getMenuListTree();
        return Result.success(menuList);
    }

    @RequestMapping("delete")
    public Result deleteMenu(@RequestBody Menu Menu) {
        Integer isMenuSubset = menuService.selectMenuSubset(Menu.getMenuId());
        if (isMenuSubset == 0) {
            menuService.deleteMenu(Menu.getMenuId());
            return Result.success();
        } else {
            return Result.failure("该菜单下有" + isMenuSubset + "个子菜单，删除失败");
        }

    }
}
