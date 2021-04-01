package flybear.hziee.app.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import flybear.hziee.app.entity.Unit;
import flybear.hziee.app.mapper.UnitMapper;
import flybear.hziee.app.service.UnitService;
@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit> implements UnitService{

}
