package cn.lyf.hotelserver.service;

import cn.lyf.hotelserver.entity.SiteDO;

import java.util.List;

public interface SiteService {

    List<SiteDO> listSites();

    int addSite(SiteDO siteDO);

    List<SiteDO> listHotSites();

    SiteDO getSiteById(Integer id);

    int deleteSite(Integer id);

    int updateSite(SiteDO siteDO);

    List<SiteDO> listSitesBySearch(String word);
}
