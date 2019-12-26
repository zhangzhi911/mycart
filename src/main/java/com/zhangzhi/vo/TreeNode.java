package com.zhangzhi.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TreeNode {

    private Serializable id;
    private String label;

    private List<TreeNode> children;
}