package com.thinkgem.jeesite.cfq.mobile.rest.utils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.ehcache.Cache;

public class SpringQuartzTimer {

    @SuppressWarnings("unchecked")
    public void execute() {
        Cache cache = SessionIdCacheUtils.getCacheManager().getCache(SessionIdCacheUtils.MOBILE_CACHE);
        // 判断缓存是否为空 如果cache为空则不做处理
        if (cache == null) {
            return;
        } else {
            // 获取缓存中所有key
            List<String> keys = cache.getKeys();
            // 根据key遍历所有value
            for (String key : keys) {
                Map<Date, Map<String, String>> ssidMap = (Map<Date, Map<String, String>>) SessionIdCacheUtils.get(key);
                // 获取子map中的key
                Set<Date> set = ssidMap.keySet();
                // 遍历子key集合判断SSID是否过期
                for (Date date : set) {
                    // 如果SSID过期清除SSID否则不做处理
                    if (DateTimeUtils.contrastDate(date)) {
                        SessionIdCacheUtils.remove(key);
                    }
                }
            }
        }
    }
}