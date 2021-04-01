package flybear.hziee.app.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import flybear.hziee.app.entity.Community;
import flybear.hziee.app.mapper.CommunityMapper;
import flybear.hziee.app.service.CommunityService;
@Service
public class CommunityServiceImpl extends ServiceImpl<CommunityMapper, Community> implements CommunityService{
    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public int addCommunity(Community community) {
        community.setCno("");
        communityMapper.insert(community);
        return communityMapper.update(
                null,
                Wrappers.<Community>lambdaUpdate()
                    .set(Community::getCno,generateCno(community.getId()))
                    .eq(Community::getId,community.getId())
        );
    }

    @Override
    public int editCommunity(Community community) {
        return communityMapper.updateById(community);
    }

    String generateCno(Long ID){
        return "C" + String.format("%05d",ID);
    }
}
