package com.example.demo.express.order.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

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
@TableName("express_order")
@ApiModel(value="ExpressOrder对象", description="")
public class ExpressOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "寄建人id")
    private Integer sendId;

    @ApiModelProperty(value = "收件人id")
    private Integer receiveId;

    @ApiModelProperty(value = "寄件类型")
    private Integer type;

    @ApiModelProperty(value = "期待上门时间")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime expectTime;

    @ApiModelProperty(value = "物品信息id")
    private Integer itemId;

    @ApiModelProperty(value = "付款方式 0寄付 1到付")
    private Integer payMethod;

    @ApiModelProperty(value = "预估总价")
    private BigDecimal estimatedTotalPrice;

    @TableField(fill = FieldFill.INSERT)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;


}
