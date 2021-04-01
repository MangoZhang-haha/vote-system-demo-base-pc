package flybear.hziee.app.service;

import flybear.hziee.app.entity.House;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

public interface HouseService extends IService<House>{

    /**
     * 添加房屋
     * @param house
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int addHouse(Long unitID,House house);

    @Transactional(rollbackFor = Exception.class)
    int editHouse(House house);

}
