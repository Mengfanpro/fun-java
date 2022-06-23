package net.mengfan.fun.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author FUN
 * @version 1.0
 * @description: 上级菜单选项实体类
 * @date 2022/6/23 13:28
 */
@Repository
@Data
public class MenuOption {

    private Integer parentMenu;

    private String label;

    private Integer value;

    private List<MenuOption> children;

}
