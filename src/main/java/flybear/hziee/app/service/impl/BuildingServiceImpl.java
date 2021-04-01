package flybear.hziee.app.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import flybear.hziee.app.entity.Building;
import flybear.hziee.app.mapper.BuildingMapper;
import flybear.hziee.app.service.BuildingService;
@Service
public class BuildingServiceImpl extends ServiceImpl<BuildingMapper, Building> implements BuildingService{

}
