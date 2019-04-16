package cn.lyf.hotelserver.util;

import java.util.UUID;

/**
 * @Title: UUIDUtils
 * @Description: UUID工具类，得到文件名
 * @author: DIC.lyf
 * @date: 2018/12/7 11:45
 * @Return:
 * @version: V1.0
 */
public class UUIDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}
