package com.ccb.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    public static <T> T MapToBean(Map map, T obj) throws InvocationTargetException, IllegalAccessException {
        BeanUtils.populate(obj, map);
        return obj;
    }
}
