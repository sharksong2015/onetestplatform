package com.shl.onetest.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:songhongli
 * @Created: 2018/7/11
 */
@Data
public class Tree<T> {
    private String id;
    private String icon;
    private String url;
    private String text;
    private Map<String, Object> state;
    private boolean checked = false;
    private Map<String, Object> attributes;
    private List<Tree<T>> children = new ArrayList<Tree<T>>();
    private String parentId;
    private boolean hasParent = false;
    private boolean hasChildren = false;

}
