package cn.xgt.vo;

import lombok.Data;

/**
 * @author XGT
 * @description 目标对象- 只包含部分字段，用于测试部分字段复制
 * @date 2025/12/26
 */
@Data
public class CopyDTO {
    private Long id;
    private String username;
    private String email;
    private Integer age;
    // 注意：不包含 balance、createTime、address、active、mobile 等字段
}
