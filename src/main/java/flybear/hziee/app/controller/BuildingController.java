package flybear.hziee.app.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import flybear.hziee.app.entity.Building;
import flybear.hziee.app.entity.Community;
import flybear.hziee.app.entity.CommunityBuilding;
import flybear.hziee.app.entity.Result;
import flybear.hziee.app.service.BuildingService;
import flybear.hziee.app.service.CommunityBuildingService;
import flybear.hziee.app.service.CommunityService;
import flybear.hziee.app.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZQL
 */
@RestController
@RequestMapping("/building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private CommunityService communityService;
    @Autowired
    private CommunityBuildingService communityBuildingService;

    /**
     * 通过小区id 查询楼宇
     * @param communityID
     * @return
     */
    @GetMapping("{communityID}")
    public Result getBuildingByCommunityID(@PathVariable String communityID){
        List<CommunityBuilding> buildingList = communityBuildingService.list(
                Wrappers.<CommunityBuilding>lambdaQuery()
                        .eq(CommunityBuilding::getCommunityId, communityID)
        );
        List<Long> buildingIDList = new ArrayList<>();
        for (CommunityBuilding communityBuilding : buildingList){
            buildingIDList.add(communityBuilding.getBuildingId());
        }
        if (buildingIDList.size() > 0){
            return ResultUtil.success(buildingService.listByIds(buildingIDList));
        }
        return ResultUtil.success(new ArrayList<>());
    }

    /**
     * 添加楼宇
     * @param communityID 小区id
     * @param building
     * @return
     */
    @PostMapping("/addBuilding")
    public Result addBuilding(@RequestParam("communityID") Long communityID, @RequestBody Building building){
        if (communityService.getById(communityID)==null){
            return ResultUtil.error("没有该小区");
        }
        if (building.getBuildingName() == null){
            return ResultUtil.error("楼宇名称不能为空");
        }
        if (building.getType() == null){
            return ResultUtil.error("楼宇类型不能为空");
        }

        int result = buildingService.addBuilding(communityID,building);
        if (result > 0){
            return ResultUtil.success("添加成功");
        }
        return ResultUtil.error("添加失败");
    }


    /**
     * 编辑楼宇内容
     * @param building
     * @return
     */
    @PutMapping("/editBuilding")
    public Result editBuilding(@RequestBody Building building){
        if (building.getId() == null){
            return ResultUtil.error("楼宇id不能为空");
        }
        //编号不能修改
        if (building.getBno() != null){
            building.setBno(null);
        }

        int result = buildingService.editBuilding(building);
        if (result > 0){
            return ResultUtil.success("修改成功");
        }
        return ResultUtil.error("修改失败");
    }

    /**
     * 通过id删除楼宇
     * @param buildingID
     * @return
     */
    @DeleteMapping("/deleteBuilding/{buildingID}")
    public Result deleteBuilding(@PathVariable String buildingID){
        if (buildingService.removeById(buildingID)) {
            return ResultUtil.success("删除成功");
        }
        return ResultUtil.error("删除失败");
    }
}
