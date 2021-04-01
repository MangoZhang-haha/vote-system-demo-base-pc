package flybear.hziee.app.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import flybear.hziee.app.entity.CommunityBuilding;
import flybear.hziee.app.mapper.CommunityBuildingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import flybear.hziee.app.entity.Building;
import flybear.hziee.app.mapper.BuildingMapper;
import flybear.hziee.app.service.BuildingService;
@Service
public class BuildingServiceImpl extends ServiceImpl<BuildingMapper, Building> implements BuildingService{
    @Autowired
    private BuildingMapper buildingMapper;
    @Autowired
    private CommunityBuildingMapper communityBuildingMapper;

    @Override
    public int addBuilding(Long communityID, Building building) {
        building.setBno("");
        buildingMapper.insert(building);
        buildingMapper.update(
                null,
                Wrappers.<Building>lambdaUpdate()
                        .set(Building::getBno,generateBno(building.getId()))
                        .eq(Building::getId,building.getId())
        );
        CommunityBuilding communityBuilding = CommunityBuilding.builder()
                .communityId(communityID)
                .buildingId(building.getId())
                .build();
        return communityBuildingMapper.insert(communityBuilding);
    }

    @Override
    public int editBuilding(Building building) {
        return buildingMapper.updateById(building);
    }

    String generateBno(Long ID){
        return "B" + String.format("%05d",ID);
    }
}
