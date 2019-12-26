package com.zhangzhi.view;

import com.zhangzhi.entity.MenuVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuVoView  {
    private Integer menuId;

    private String name;

    private String path;

    private Integer parentId;
    private List<MenuVoView> children;
}
