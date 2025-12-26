package cn.xgt.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONUtil;
import cn.xgt.vo.MaskEntity;

/**
 * @author XGT
 * @description Mask Test
 * @date 2025/12/3
 */
@RestController
@RequestMapping(value = "restful/mask")
public class MaskApi {

  private Logger logger = LoggerFactory.getLogger(MaskApi.class);

  /**
   * 使用@Mask注解自动脱敏（返回JSON时自动脱敏）
   *
   * eg:
   * {
   *   "name": "张三李四王五",
   *   "mobile": "13800138000",
   *   "cardNo": "110112200801010739",
   *   "bankCardNo": "6222807728905421317",
   *   "email": "zhangsan@example.com",
   *   "address": "北京市朝阳区建国路001号",
   *   "money": "1234567890",
   *   "customField": "张三李四王五",
   *   "normalField": "张三李四王五"
   * }
   */
  @PostMapping(value = "getInfo1")
  public MaskEntity getInfo1(@RequestBody Map<String, Object> param) {
    MaskEntity maskEntity = new MaskEntity();
    maskEntity.setName(MapUtil.getStr(param, MaskEntity.Fields.name));
    maskEntity.setMobile(MapUtil.getStr(param, MaskEntity.Fields.mobile));
    maskEntity.setCardNo(MapUtil.getStr(param, MaskEntity.Fields.cardNo));
    maskEntity.setBankCardNo(MapUtil.getStr(param, MaskEntity.Fields.bankCardNo));
    maskEntity.setEmail(MapUtil.getStr(param, MaskEntity.Fields.email));
    maskEntity.setAddress(MapUtil.getStr(param, MaskEntity.Fields.address));
    maskEntity.setMoney(MapUtil.getStr(param, MaskEntity.Fields.money));
    maskEntity.setCustomField(MapUtil.getStr(param, MaskEntity.Fields.customField));
    maskEntity.setNormalField(MapUtil.getStr(param, MaskEntity.Fields.normalField));

    logger.info("========================customerEntity:{}", JSONUtil.toJsonStr(maskEntity));
    return maskEntity;
  }
}
