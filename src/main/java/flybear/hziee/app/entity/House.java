package flybear.hziee.app.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "house")
public class House implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 房屋编号(H + id, id不满9位补0)
     */
    @TableId(value = "hno", type = IdType.INPUT)
    private String hno;

    /**
     * 门牌号
     */
    @TableField(value = "house_number")
    private String houseNumber;

    /**
     * 所在楼层
     */
    @TableField(value = "floor")
    private Integer floor;

    /**
     * 建筑面积
     */
    @TableField(value = "area_floor")
    private Double areaFloor;

    /**
     * 套内面积
     */
    @TableField(value = "area_house")
    private Double areaHouse;

    /**
     * 公摊面积
     */
    @TableField(value = "area_shared")
    private Double areaShared;

    /**
     * 房屋类型
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 产权年限
     */
    @TableField(value = "term_of_property_right")
    private String termOfPropertyRight;

    /**
     * 投票权数
     */
    @TableField(value = "vote_weight")
    private Integer voteWeight;

    /**
     * 房屋朝向
     */
    @TableField(value = "orientation")
    private String orientation;

    /**
     * 房屋户型
     */
    @TableField(value = "house_layout")
    private String houseLayout;

    /**
     * 房屋总物业费
     */
    @TableField(value = "property_management_fee")
    private Double propertyManagementFee;

    /**
     * 房屋排序
     */
    @TableField(value = "sort")
    private String sort;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    @TableField(value = "deleted")
    private Boolean deleted;

    @TableField(value = "gmt_create",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date gmtCreate;

    @TableField(value = "gmt_modified",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_HNO = "hno";

    public static final String COL_HOUSE_NUMBER = "house_number";

    public static final String COL_FLOOR = "floor";

    public static final String COL_AREA_FLOOR = "area_floor";

    public static final String COL_AREA_HOUSE = "area_house";

    public static final String COL_AREA_SHARED = "area_shared";

    public static final String COL_TYPE = "type";

    public static final String COL_TERM_OF_PROPERTY_RIGHT = "term_of_property_right";

    public static final String COL_VOTE_WEIGHT = "vote_weight";

    public static final String COL_ORIENTATION = "orientation";

    public static final String COL_HOUSE_LAYOUT = "house_layout";

    public static final String COL_PROPERTY_MANAGEMENT_FEE = "property_management_fee";

    public static final String COL_SORT = "sort";

    public static final String COL_REMARK = "remark";

    public static final String COL_DELETED = "deleted";

    public static final String COL_GMT_CREATE = "gmt_create";

    public static final String COL_GMT_MODIFIED = "gmt_modified";
}