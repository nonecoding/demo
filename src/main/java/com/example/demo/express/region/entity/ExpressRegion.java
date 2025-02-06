package com.example.demo.express.region.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import com.example.demo.common.utils.LocalDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xj
 * @since 2025-02-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("express_region")
@ApiModel(value="ExpressRegion对象", description="")
public class ExpressRegion implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "区域名称")
    private String name;

    @ApiModelProperty(value = "上级区域 id，如果为空表示顶层省份")
    private Integer parentId;

    @ApiModelProperty(value = "区域级别，如 1 省, 2 市, 3 区")
    private Integer level;

    @TableField(fill = FieldFill.INSERT)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;

    // 孩子节点，便于递归构造树形结构
    // children 字段仅用于构造树形结构，不对应数据库表字段
    @TableField(exist = false)
    @ApiModelProperty(value = "子区域集合")
    private List<ExpressRegion> children;
}
