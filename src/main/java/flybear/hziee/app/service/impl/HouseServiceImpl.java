package flybear.hziee.app.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import flybear.hziee.app.entity.House;
import flybear.hziee.app.mapper.HouseMapper;
import flybear.hziee.app.service.HouseService;
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements HouseService{

}
