package net.mengfan.fun.domain;

import org.springframework.stereotype.Repository;


/**
 *
 */
@Repository
public class Menu {

    /**
     * 菜单ID
     */
    private Integer menuId;

    /**
     * 父级菜单
     */
    private String parentMenu;

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

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(String parentMenu) {
        this.parentMenu = parentMenu;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", parentMenu='" + parentMenu + '\'' +
                ", menuType=" + menuType +
                ", menuName='" + menuName + '\'' +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", icon='" + icon + '\'' +
                ", status=" + status +
                ", sort=" + sort +
                '}';
    }
}
