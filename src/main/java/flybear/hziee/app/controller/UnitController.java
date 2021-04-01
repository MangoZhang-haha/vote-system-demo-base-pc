package flybear.hziee.app.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import flybear.hziee.app.entity.Result;
import flybear.hziee.app.entity.Unit;
import flybear.hziee.app.service.BuildingService;
import flybear.hziee.app.service.UnitService;
import flybear.hziee.app.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZQL
 */
@RestController
@RequestMapping("/unit")
public class UnitController {
    @Autowired
    private UnitService unitService;
    @Autowired
    private BuildingService buildingService;

    /**
     * 通过楼宇id 查询单元
     * @param buildingID
     * @return
     */
    @GetMapping("{buildingID}")
    public Result getUnitByBuildingID(@PathVariable String buildingID){
        return ResultUtil.success(unitService.list(
                Wrappers.<Unit>lambdaQuery()
                        .eq(Unit::getBuildingId,buildingID)
        ));
    }

    /**
     * 添加单元
     * @param unit
     * @return
     */
    @PostMapping("/addUnit")
    public Result addUnit(@RequestBody Unit unit){
        if (unit.getBuildingId() == null){
            return  ResultUtil.error("楼宇id不能为空");
        }
        if (unit.getUnit() == null){
            return ResultUtil.error("单元号不能为空");
        }
        if (unit.getUnitName() == null){
            return ResultUtil.error("单元名称不能为空");
        }
        if (buildingService.getById(unit.getBuildingId()) == null){
            return ResultUtil.error("该楼宇不存在");
        }

        int result = unitService.addUnit(unit);
        if (result > 0){
            return ResultUtil.success("添加成功");
        }
        return ResultUtil.error("添加失败");
    }

    /**
     * 编辑单元内容
     * @param unit
     * @return
     */
    @PutMapping("/editUnit")
    public Result editUnit(@RequestBody Unit unit){
        if (unit.getId() == null){
            return ResultUtil.error("单元id不能为空");
        }
        int result = unitService.editUnit(unit);
        if (result > 0){
            return ResultUtil.success("修改成功");
        }
        return ResultUtil.error("修改失败");
    }

    /**
     * 通过id删除单元
     * @param unitID
     * @return
     */
    @DeleteMapping("/deleteUnit/{unitID}")
    public Result deleteUnit(@PathVariable String unitID){
        if (unitService.removeById(unitID)) {
            return ResultUtil.success("删除成功");
        }
        return ResultUtil.error("删除失败");
    }
}
