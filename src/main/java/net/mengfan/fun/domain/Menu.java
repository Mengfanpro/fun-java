package net.mengfan.fun.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 *
 */
@Repository
@Data
public class Menu {

    /**
     * 菜单ID
     */
    private Integer menuId;

    /**
     * 父级菜单
     */
    private Integer parentMenu;

    /**
     * 菜单类型
     */
    private Integer menuType;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 请求路径
     */
    private String url;

    /**
     * 页面地址
     */
    private String path;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单状态
     */
    private Integer status;

    /**
     * 菜单排序
     */
    private Integer sort;

    /**
     * 菜单子集
     */
    private List<Menu> children;
}
