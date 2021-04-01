package flybear.hziee.app.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import flybear.hziee.app.entity.House;
import flybear.hziee.app.entity.Result;
import flybear.hziee.app.entity.UnitHouse;
import flybear.hziee.app.service.HouseService;
import flybear.hziee.app.service.UnitHouseService;
import flybear.hziee.app.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZQL
 */
@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private UnitHouseService unitHouseService;

    /**
     * 通过单元id获取房屋
     * @param unitID
     * @return
     */
    @GetMapping("/{unitID}")
    public Result getHouse(@PathVariable String unitID){
        List<UnitHouse> unitHouseList = unitHouseService.list(
                Wrappers.<UnitHouse>lambdaQuery()
                        .eq(UnitHouse::getUnitTableId, unitID)
        );
        List<Long> houseIDList = new ArrayList<>();
        for (UnitHouse unitHouse : unitHouseList){
            houseIDList.add(unitHouse.getHouseId());
        }
        if (houseIDList.size() > 0){
           return ResultUtil.success(houseService.listByIds(houseIDList));
        }
        return ResultUtil.success(new ArrayList<>());
    }

    /**
     * 添加房屋
     * @return
     */
    @PostMapping("/addHouse")
    public Result addHouse(@RequestParam("unitID")Long unitID,@RequestBody House house){
        if (house.getHouseNumber() == null){
            return ResultUtil.error("门牌号不能为空");
        }
        int result = houseService.addHouse(unitID,house);
        if (result > 0){
            return ResultUtil.success("添加成功");
        }
        return ResultUtil.success(house);
    }

    /**
     * 编辑房屋内容
     * @param house
     * @return
     */
    @PutMapping("/editHouse")
    public Result editHouse(@RequestBody House house){
        if (house.getId() == null){
            return ResultUtil.error("房屋id不能为空");
        }
        if (house.getHno() != null){
            house.setHno(null);
        }

        int result = houseService.editHouse(house);
        if (result > 0){
            return ResultUtil.success("修改成功");
        }
        return ResultUtil.error("修改失败");
    }

    /**
     * 通过id 删除房屋
     * @param houseID
     * @return
     */
    @DeleteMapping("/deleteHouse/{houseID}")
    public Result deleteHouse(@PathVariable String houseID){
        if (houseService.removeById(houseID)) {
            return ResultUtil.success("删除成功");
        }
        return ResultUtil.error("删除失败");
    }
}
