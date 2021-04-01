package flybear.hziee.app.service;

import flybear.hziee.app.entity.Unit;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

public interface UnitService extends IService<Unit>{

    @Transactional(rollbackFor = Exception.class)
    int addUnit(Unit unit);

    @Transactional(rollbackFor = Exception.class)
    int editUnit(Unit unit);
}
