package cn.xgt.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author XGT
 * @description 目标对象- 包含所有字段 + 扩展字段，用于测试回调功能
 * @date 2025/12/26
 */
@Data
public class CopyVO {
    // 基础字段（从CopyEntity复制）
    private Long id;
    private String username;
    private String email;
    private Integer age;
    private BigDecimal balance;
    private Date createTime;
    private String address;
    private Boolean active;
    private String mobile;

    // 扩展字段（通过回调设置）
    private String balanceStr;          // 格式化后的金额字符串
    private String createTimeStr;       // 格式化后的时间字符串
    private String userLevel;           // 用户等级（VIP客户/高级客户/普通客户）
    private String displayInfo;          // 显示信息（用户名 - 手机号）
    private String statusDesc;           // 状态描述（活跃用户/非活跃用户）
}
