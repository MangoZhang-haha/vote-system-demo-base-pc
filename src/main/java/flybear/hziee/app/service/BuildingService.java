package flybear.hziee.app.service;

import flybear.hziee.app.entity.Building;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

public interface BuildingService extends IService<Building>{

    @Transactional(rollbackFor = Exception.class)
    int addBuilding(Long communityID,Building building);

    @Transactional(rollbackFor = Exception.class)
    int editBuilding(Building building);
}
