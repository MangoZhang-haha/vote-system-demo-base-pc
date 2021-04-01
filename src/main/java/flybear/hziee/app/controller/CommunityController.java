package flybear.hziee.app.controller;

import flybear.hziee.app.entity.Community;
import flybear.hziee.app.entity.Result;
import flybear.hziee.app.service.CommunityService;
import flybear.hziee.app.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZQL
 */
@RestController
@RequestMapping("/community")
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    /**
     * 获取所有小区
     * @return
     */
    @GetMapping
    public Result getCommunity(){
        return ResultUtil.success(communityService.list());
    }

    /**
     * 添加小区
     * @param community
     * @return
     */
    @PostMapping("/addCommunity")
    public Result addCommunity(@RequestBody Community community){
        if (community.getCommunityName() == null){
            return ResultUtil.error("小区名称不能为空");
        }
        if (community.getRegion() == null){
            return ResultUtil.error("所在地区不能为空");
        }
        int result = communityService.addCommunity(community);
        if (result > 0){
            return ResultUtil.success("添加成功");
        }
        return ResultUtil.error("添加失败");
    }

    /**
     * 编辑小区内容
     * @param community
     * @return
     */
    @PutMapping("/editCommunity")
    public Result editCommunity(@RequestBody Community community){
        if (community.getId() == null){
            return ResultUtil.error("小区id不能为空");
        }
        //编号不能修改
        if (community.getCno() != null){
            community.setCno(null);
        }
        if (communityService.getById(community.getId()) == null){
            return ResultUtil.error("该小区不存在");
        }

        int result = communityService.editCommunity(community);
        if (result > 0){
            return ResultUtil.success("修改成功");
        }
        return ResultUtil.error("修改失败");
    }

    /**
     * 通过id删除小区
     * @param communityID
     * @return
     */
    @DeleteMapping("/deleteCommunity/{communityID}")
    public Result deleteCommunity(@PathVariable String communityID){
        if (communityService.removeById(communityID)){
            return ResultUtil.success("删除成功");
        }
        return ResultUtil.error("删除失败");
    }
}
