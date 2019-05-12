package cn.lyf.hotelserver.dao;

import cn.lyf.hotelserver.entity.SiteDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteDao {

    List<SiteDO> listSites();

    int addSite(SiteDO siteDO);

    List<SiteDO> listHotSites();

    SiteDO getSiteById(Integer id);

    int deleteSite(Integer id);

    int updateSite(SiteDO siteDO);

    List<SiteDO> listSitesBySearch(String word);
}
