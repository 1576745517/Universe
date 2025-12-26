package cn.xgt.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author XGT
 * @description 源对象
 * @date 2025/12/26
 */
@Data
public class CopyEntity {
    private Long id;                    // Long类型
    private String username;            // String类型
    private String email;               // String类型
    private Integer age;                // Integer类型
    private BigDecimal balance;         // BigDecimal类型
    private Date createTime;            // Date类型
    private String address;             // String类型
    private Boolean active;             // Boolean类型
    private String mobile;              // String类型（手机号）
}
