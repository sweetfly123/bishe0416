package cn.lyf.staticresourceserver.utils;

/**
 * @author DIC.lyf
 * @version V1.0
 * @Title: ServiceExcetion
 * @Package cn.lyf.staticresourceserver.utils
 * @Description: (用一句话描述该文件做什么)
 * @date 2018/12/18 15:42
 */
public class ServiceExcetion extends RuntimeException {
     public static final long serialVersionUID = 1L;

     public ServiceExcetion(String msg){
         super(msg);
     }
     public ServiceExcetion(){super();}
}
