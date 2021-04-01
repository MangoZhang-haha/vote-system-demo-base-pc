package flybear.hziee.app.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import flybear.hziee.app.entity.Community;
import flybear.hziee.app.mapper.CommunityMapper;
import flybear.hziee.app.service.CommunityService;
@Service
public class CommunityServiceImpl extends ServiceImpl<CommunityMapper, Community> implements CommunityService{

}
