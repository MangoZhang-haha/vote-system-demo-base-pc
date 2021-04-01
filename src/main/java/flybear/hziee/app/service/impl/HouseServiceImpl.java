package flybear.hziee.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import flybear.hziee.app.entity.UnitHouse;
import flybear.hziee.app.mapper.UnitHouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import flybear.hziee.app.entity.House;
import flybear.hziee.app.mapper.HouseMapper;
import flybear.hziee.app.service.HouseService;
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements HouseService{
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private UnitHouseMapper unitHouseMapper;

    @Override
    public int addHouse(Long unitID,House house) {
        house.setHno("");
        houseMapper.insert(house);
        houseMapper.update(
                null,
                Wrappers.<House>lambdaUpdate()
                        .set(House::getHno,generateHno(house.getId()))
                        .eq(House::getId,house.getId())
        );
        UnitHouse unitHouse = UnitHouse.builder()
                .unitTableId(unitID)
                .houseId(house.getId())
                .build();
        return unitHouseMapper.insert(unitHouse);
    }

    @Override
    public int editHouse(House house) {
        return houseMapper.updateById(house);
    }

    public String generateHno(Long ID){
        return "H"+String.format("%08d",ID);
    }
}
