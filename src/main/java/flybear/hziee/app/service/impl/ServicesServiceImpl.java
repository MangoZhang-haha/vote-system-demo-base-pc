package flybear.hziee.app.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import flybear.hziee.app.mapper.ServicesMapper;
import flybear.hziee.app.entity.Services;
import flybear.hziee.app.service.ServicesService;
@Service
public class ServicesServiceImpl extends ServiceImpl<ServicesMapper, Services> implements ServicesService{

}
