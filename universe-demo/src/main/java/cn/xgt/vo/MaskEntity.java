package cn.xgt.vo;
/**
 * @description TODO
 * @author XGT
 * @date 2023/12/27
 */

import cn.xgt.universe.mask.anontation.Mask;
import cn.xgt.universe.mask.constant.CATEGORT;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

/**
 * @author XGT
 * @description MaskEntity
 * @date 2025/12/3
 */
@Data
@FieldNameConstants
public class MaskEntity {
    /**
     *
     */
    /** 客户姓名 - 使用姓名脱敏策略 */
    @Mask(category = CATEGORT.NAME)
    private String name;

    /** 手机号 - 使用手机号脱敏策略 */
    @Mask(category = CATEGORT.MOBILE)
    private String mobile;

    /** 证件号 - 使用身份证脱敏策略 */
    @Mask(category = CATEGORT.ID_NUM)
    private String cardNo;

    /** 银行卡号 - 使用银行卡脱敏策略 */
    @Mask(category = CATEGORT.CARD_NUM)
    private String bankCardNo;

    /** 邮箱 - 使用邮箱脱敏策略 */
    @Mask(category = CATEGORT.EMAIL)
    private String email;

    /** 地址 - 使用地址脱敏策略 */
    @Mask(category = CATEGORT.ADDRESS)
    private String address;

    /** 金额 - 使用金额脱敏策略 */
    @Mask(category = CATEGORT.MONEY)
    private String money;

    /** 自定义脱敏 - 显示前3位，后2位 */
    @Mask(category = CATEGORT.CUSTOM, prefixNoMaskLen = 3, suffixNoMaskLen = 3, asterisk = "*")
    private String customField;

    /** 正常返现字段.非脱敏 */
    private String normalField;


}
