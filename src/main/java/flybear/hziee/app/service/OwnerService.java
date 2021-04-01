package flybear.hziee.app.service;

import flybear.hziee.app.entity.Owner;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

public interface OwnerService extends IService<Owner>{


    @Transactional(rollbackFor = Exception.class)
    int addOwner(Long houseID,Owner owner);

    @Transactional(rollbackFor = Exception.class)
    int editOwner(Owner owner);
}
