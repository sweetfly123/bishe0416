package cn.lyf.hotelserver.service;

import cn.lyf.hotelserver.entity.SiteDO;

import java.util.List;

public interface SiteService {

    List<SiteDO> listSites();

    int addSite(SiteDO siteDO);
}
