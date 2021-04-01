package flybear.hziee.app.service;

import flybear.hziee.app.entity.Community;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

public interface CommunityService extends IService<Community>{

    @Transactional(rollbackFor = Exception.class)
    int addCommunity(Community community);

    @Transactional(rollbackFor = Exception.class)
    int editCommunity(Community community);
}
