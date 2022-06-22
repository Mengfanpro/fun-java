package net.mengfan.fun.dao;

import net.mengfan.fun.domain.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MenuMapper {

    /**
     * 新增菜单
     * @param menu
     * @return
     */
    Integer insertMenu(Menu menu);

    Integer selectMenuByName(String menuName);
}
