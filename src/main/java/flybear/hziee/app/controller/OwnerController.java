package flybear.hziee.app.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import flybear.hziee.app.entity.Owner;
import flybear.hziee.app.entity.OwnerHouse;
import flybear.hziee.app.entity.Result;
import flybear.hziee.app.service.HouseService;
import flybear.hziee.app.service.OwnerHouseService;
import flybear.hziee.app.service.OwnerService;
import flybear.hziee.app.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZQL
 */
@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private OwnerHouseService ownerHouseService;
    @Autowired
    private HouseService houseService;

    /**
     * 通过房屋id 获取住户信息
     * @param houseID
     * @return
     */
    @GetMapping("{houseID}")
    public Result getOwnerByHouseID(@PathVariable String houseID){
        List<OwnerHouse> ownerHouseList = ownerHouseService.list(
                Wrappers.<OwnerHouse>lambdaQuery()
                        .eq(OwnerHouse::getHouseId, houseID)
        );
        List<Long> ownerIDList = new ArrayList<>();
        for (OwnerHouse ownerHouse : ownerHouseList){
            ownerIDList.add(ownerHouse.getOwnerId());
        }
        if (ownerIDList.size() > 0){
            return ResultUtil.success(ownerService.listByIds(ownerIDList));
        }
        return ResultUtil.success(new ArrayList<>());
    }

    /**
     * 添加住户
     * @param houseID 房屋id
     * @param owner
     * @return
     */
    @PostMapping("/addOwner")
    public Result addOwner(@RequestParam("houseID")Long houseID, @RequestBody Owner owner){
        if (houseService.getById(houseID) == null) {
            return ResultUtil.error("房屋不存在");
        }
        if (owner.getOid() == null){
            return ResultUtil.error("业主id不能为空");
        }
        if (owner.getOwnerName() == null) {
            return ResultUtil.error("业主姓名不能为空");
        }
        if (owner.getIdNumber() == null) {
            return ResultUtil.error("业主身份证号不能为空");
        }

        int result = ownerService.addOwner(houseID,owner);
        if (result > 0){
            return ResultUtil.success("添加成功");
        }
        return ResultUtil.error("添加失败");
    }

    /**
     * 编辑用户信息
     * @param owner
     * @return
     */
    @PutMapping("/editOwner")
    public Result editOwner(@RequestBody Owner owner){
        if (owner.getId() == null) {
            return ResultUtil.error("住户id不能为空");
        }
        int result = ownerService.editOwner(owner);
        if (result > 0){
            return ResultUtil.success("修改成功");
        }
        return ResultUtil.error("修改失败");
    }

    /**
     * 通过id删除住户
     * @param ownerID
     * @return
     */
    @DeleteMapping("/deleteOwner/{ownerID}")
    public Result deletOwner(@PathVariable String ownerID){
        if (ownerService.removeById(ownerID)) {
            return ResultUtil.success("删除成功");
        }
        return ResultUtil.error("删除失败");
    }
}
