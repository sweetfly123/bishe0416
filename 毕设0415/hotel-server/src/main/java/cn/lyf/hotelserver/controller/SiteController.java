package cn.lyf.hotelserver.controller;

import cn.lyf.hotelserver.entity.SiteDO;
import cn.lyf.hotelserver.service.SiteService;
import cn.lyf.hotelserver.util.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sites")
public class SiteController {

    @Value("${web.upload-path}")
    private String path;
    @Resource
    private SiteService siteService;


    @RequestMapping(method = RequestMethod.GET)
    public List<SiteDO> listSites(){
        List<SiteDO> siteDOS = siteService.listSites();
        return siteDOS;
    }

    @RequestMapping(value = "/search/{word}",method = RequestMethod.GET)
    public List<SiteDO> listSitesBySearch(@PathVariable("word") String word){
        if (word.equals("nothing")){
            word ="";
        }
        List<SiteDO> siteDOS = siteService.listSitesBySearch(word);
        return siteDOS;
    }

    @RequestMapping(value = "/hot",method = RequestMethod.GET)
    public List<SiteDO> listHotSites(){
        List<SiteDO> siteDOS = siteService.listHotSites();
        return siteDOS;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public SiteDO getSiteById(@PathVariable Integer id){
        SiteDO site = siteService.getSiteById(id);
        return site;
    }


    @RequestMapping(method = RequestMethod.POST)
    public String addSite(MultipartFile[] files, SiteDO siteDO){
        String msg = "";
        String realPath = path + "sites/";
        String picturePaths = "";
        for(MultipartFile file:files){
            if (FileUtils.upload(file, realPath, file.getOriginalFilename())) {
                // 上传成功，给出页面提示
                msg = "上传成功！";
            } else {
                msg = "上传失败！";
            }
            picturePaths += file.getOriginalFilename()+"!!";
        }
        siteDO.setSitePicturePath(picturePaths);
        // hotelDO.setRoomPicturePath(resourceLoader.getResource("file:" + path + fileName));
        siteDO.setVisitTimes("0");
        siteService.addSite(siteDO);
        return msg;
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.DELETE)
    public int deleteHouse(@PathVariable("Id") Integer Id) {
        int result = siteService.deleteSite(Id);
        return result;
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public String updateSite(MultipartFile[] files,SiteDO siteDO) {
        String msg = "";
        String realPath = path + "sites/";
        String picturePaths = "";
        if(files != null){
            for (MultipartFile file : files) {
                if (FileUtils.upload(file, realPath, file.getOriginalFilename())) {
                    msg = "上传成功！";
                } else {
                    msg = "上传失败！";
                }
                picturePaths += file.getOriginalFilename() + "!!";
            }
        }
        siteDO.setSitePicturePath(picturePaths);
        siteService.updateSite(siteDO);
        return msg;
    }
}
