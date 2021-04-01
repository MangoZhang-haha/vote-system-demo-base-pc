package flybear.hziee.app.service.impl;

import flybear.hziee.app.entity.OwnerHouse;
import flybear.hziee.app.mapper.OwnerHouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import flybear.hziee.app.entity.Owner;
import flybear.hziee.app.mapper.OwnerMapper;
import flybear.hziee.app.service.OwnerService;
@Service
public class OwnerServiceImpl extends ServiceImpl<OwnerMapper, Owner> implements OwnerService{
    @Autowired
    private OwnerMapper ownerMapper;
    @Autowired
    private OwnerHouseMapper ownerHouseMapper;

    @Override
    public int addOwner(Long houseID, Owner owner) {
        ownerMapper.insert(owner);
        OwnerHouse ownerHouse = OwnerHouse.builder()
                .houseId(houseID)
                .ownerId(owner.getId())
                .build();
        return ownerHouseMapper.insert(ownerHouse);
    }

    @Override
    public int editOwner(Owner owner) {
        return ownerMapper.updateById(owner);
    }
}
