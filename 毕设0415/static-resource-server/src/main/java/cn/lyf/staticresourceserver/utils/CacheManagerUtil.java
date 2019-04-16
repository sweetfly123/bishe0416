package cn.lyf.staticresourceserver.utils;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.Calendar;
import java.util.Map;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @author DIC.lyf
 * @version V1.0
 * @Title: CacheManagerUtil
 * @Package cn.lyf.staticresourceserver.utils
 * @Description: 缓存工具类
 * @date 2018/12/18 15:53
 */
public class CacheManagerUtil {
    //使用map作为缓存
    private static Map<String, CacheData> cache = new ConcurrentHashMap<>();

    static {
//        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();
        //手动创建线程池
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("cache-schedule-pool-%d").daemon(true).build());
        scheduledExecutorService.schedule(new ClearTimerTask(cache),24, TimeUnit.HOURS);
    }


    private static class CacheData<T> {
        //缓存数据
        private T data;
        //过期时间
        private long expireTime;

        //构造函数
        private CacheData(T data, long expireTime) {
            this.data = data;
            if (expireTime <= 0) {
                this.expireTime = 0L;
            } else {
                this.expireTime = Calendar.getInstance().getTimeInMillis() + expireTime;
            }
        }

        //判断缓存数据是否过期
        private boolean expire() {
            if (expireTime <= 0) {
                return false;
            }
            if (expireTime > Calendar.getInstance().getTimeInMillis()) {
                return false;
            }
            return true;
        }

        private T getData() {
            return data;
        }
    }

    /**
     * @method:
     * @Param: * @param null
     * @Description: 定时清理缓存
     * @author: DIC.lyf
     * @date: 2018/12/18 16:29
     * @Return:
     * @version: V1.0
     */
    private static class ClearTimerTask extends TimerTask {

        Map<String, CacheData> cache;

        public ClearTimerTask(Map<String, CacheData> cache) {
            this.cache = cache;
        }

        @Override
        public void run() {
            //keySet 获取map中所有的key
            Set<String> keys = cache.keySet();
            for (String key : keys) {
                CacheData<?> data = cache.get(key);
                if (data.expireTime <= 0) {
                    continue;
                }
                if (data.expireTime > Calendar.getInstance().getTimeInMillis()) {
                    continue;
                }
                cache.remove(key);
            }
        }
    }

    /**
     * 设置不过期的缓存
     *
     * @param key
     * @param t
     * @param <T>
     */
    public static <T> void set(String key, T t) {
        cache.put(key, new CacheData<>(t, 0));
    }

    /**
     * 设置缓存，指定到期时间
     *
     * @param key
     * @param t
     * @param expirtTime
     * @param <T>
     */
    public static <T> void set(String key, T t, long expirtTime) {
        cache.put(key, new CacheData<>(t, expirtTime));
    }

    public static <T> T get(String key) {
        CacheData<T> data = cache.get(key);
        if (null == data) {
            return null;
        }
        if (data.expire()) {
            remove(key);
            return null;
        }
        return data.getData();
    }

    /**
     * 移除指定缓存
     *
     * @param key
     */
    public static void remove(String key) {
        cache.remove(key);
    }

    /**
     * 清除所有缓存
     */
    public static void removeAll() {
        cache.clear();
    }
}
