package net.mengfan.fun.dao;

import net.mengfan.fun.domain.Menu;
import net.mengfan.fun.domain.MenuOption;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuMapper {

    /**
     * 新增菜单
     *
     * @param menu
     * @return
     */
    Integer insertMenu(Menu menu);

    /**
     * 查询是否存在相同名称菜单
     *
     * @param menuName
     * @return
     */
    Integer selectMenuByName(String menuName);

    /**
     * 查询上级菜单选项
     *
     * @return
     */
    List<MenuOption> selectMenuListTree();

    /**
     * 查询全部菜单列表
     *
     * @return
     */
    List<Menu> selectMenuAll();

    /**
     * 根据菜单id查询是否有子菜单
     * @param parentMenu
     * @return
     */
    Integer selectMenuSubset(Integer parentMenu);

    /**
     * 删除菜单
     * @param menuId
     */
    void deleteMenu(Integer menuId);
}
