package cn.lyf.hotelserver.service.Impl;

import cn.lyf.hotelserver.dao.SiteDao;
import cn.lyf.hotelserver.entity.SiteDO;
import cn.lyf.hotelserver.service.SiteService;
import cn.lyf.hotelserver.util.ServiceExcetion;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {

    @Resource
    private SiteDao siteDao;

    @Override
    public List<SiteDO> listSites() {
        List<SiteDO> siteDOS = siteDao.listSites();
        for (SiteDO site : siteDOS) {
            String sitePicturePath = site.getSitePicturePath();
            sitePicturePath = sitePicturePath.substring(0, sitePicturePath.length() - 2);
            site.setPictures(Arrays.asList(sitePicturePath.split("!!")));
        }
        return siteDOS;
    }

    @Override
    public int addSite(SiteDO siteDO) {
        int flag = 0;
        try {
            flag = siteDao.addSite(siteDO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceExcetion("添加失败");
        } finally {
            return flag;
        }
    }

    @Override
    public List<SiteDO> listHotSites() {
        List<SiteDO> siteDOS = siteDao.listHotSites();
        for (SiteDO site : siteDOS) {
            String sitePicturePath = site.getSitePicturePath();
            sitePicturePath = sitePicturePath.substring(0, sitePicturePath.length() - 2);
            site.setPictures(Arrays.asList(sitePicturePath.split("!!")));
        }
        return siteDOS;
    }

    @Override
    public SiteDO getSiteById(Integer id) {
        SiteDO site = siteDao.getSiteById(id);
        String sitePicturePath = site.getSitePicturePath();
        sitePicturePath = sitePicturePath.substring(0, sitePicturePath.length() - 2);
        site.setPictures(Arrays.asList(sitePicturePath.split("!!")));
        return site;
    }
}
