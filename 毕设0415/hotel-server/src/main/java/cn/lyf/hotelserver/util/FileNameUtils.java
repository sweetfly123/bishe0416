package cn.lyf.hotelserver.util;

/**
 * @Title: FileNameUtils
 * @Description: 获取上传文件名工具类
 * @author: DIC.lyf
 * @date: 2018/12/7 11:44
 * @Return:
 * @version: V1.0
 */
public class FileNameUtils {

    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成新的文件名
     * @param fileOriginName 源文件名
     * @return
     */
    public static String getFileName(String fileOriginName){
        return UUIDUtils.getUUID() + FileNameUtils.getSuffix(fileOriginName);
    }

}
