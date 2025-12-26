package cn.xgt.universe.common.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author XGT
 * @description BeanCopyUtils: bean copy
 *              BeanUtils的一个封装,增加对集合的拷贝.
 *              性能损耗基本可以忽略不计,仅多了一层函数堆栈的调用，性能基本取决于BeanUtils
 * @date 2025/12/26
 */
public class BeanCopyUtils extends BeanUtils {

    public static <S, T> T convertTo(S source, Supplier<T> targetSupplier) {
        return convertTo(source, targetSupplier, null);
    }

    /**
     * 转换对象
     *
     * @param source         源对象
     * @param targetSupplier 目标对象供应方
     * @param callBack       回调方法.在属性复制完成后执行自定义逻辑，用于处理无法通过属性复制完成的特殊字段或业务逻辑。
     * @param <S>            源对象类型
     * @param <T>            目标对象类型
     * @return 目标对象
     */
    public static <S, T> T convertTo(S source, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack) {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(targetSupplier, "TargetSupplier must not be null");

        T target = targetSupplier.get();
        Assert.notNull(target, "Target object must not be null. TargetSupplier.get() returned null");

        copyProperties(source, target);
        if (callBack != null) {
            callBack.callBack(source, target);
        }
        return target;
    }

    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier) {
        return convertListTo(sources, targetSupplier, null, true);
    }

    /**
     * 转换对象列表
     *
     * @param sources        源对象list
     * @param targetSupplier 目标对象供应方
     * @param callBack       回调方法.在属性复制完成后执行自定义逻辑，用于处理无法通过属性复制完成的特殊字段或业务逻辑。
     * @param <S>            源对象类型
     * @param <T>            目标对象类型
     * @return 目标对象list
     */
    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack) {
        return convertListTo(sources, targetSupplier, callBack, true);
    }

    /**
     * 转换对象列表（简化版，跳过null值）
     *
     * @param sources        源对象list
     * @param targetSupplier 目标对象供应方
     * @param skipNull       是否跳过null值。true-跳过null值（默认），false-保留null值到结果列表
     * @param <S>            源对象类型
     * @param <T>            目标对象类型
     * @return 目标对象list
     */
    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier, boolean skipNull) {
        return convertListTo(sources, targetSupplier, null, skipNull);
    }

    /**
     * 转换对象列表
     *
     * @param sources        源对象list
     * @param targetSupplier 目标对象供应方
     * @param callBack       回调方法.在属性复制完成后执行自定义逻辑，用于处理无法通过属性复制完成的特殊字段或业务逻辑。
     * @param <S>            源对象类型
     * @param <T>            目标对象类型
     * @return 目标对象list
     */
    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack, boolean skipNull) {
        Assert.notNull(sources, "Sources list must not be null");
        Assert.notEmpty(sources, "Sources list must not be empty");
        Assert.notNull(targetSupplier, "TargetSupplier must not be null");

        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            if (source == null) {
                if (skipNull) {
                    continue; // 跳过null值
                } else {
                    list.add(null); // 保留null值到结果列表
                    continue;
                }
            }

            T target = targetSupplier.get();
            Assert.notNull(target, "Target object must not be null. TargetSupplier.get() returned null");


            copyProperties(source, target);
            if (callBack != null) {
                callBack.callBack(source, target);
            }
            list.add(target);
        }
        return list;
    }

    /**
     * 回调接口
     *
     * @param <S> 源对象类型
     * @param <T> 目标对象类型
     */
    @FunctionalInterface
    public interface ConvertCallBack<S, T> {
        void callBack(S source, T target);
    }
}
