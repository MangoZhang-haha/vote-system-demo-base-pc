package flybear.hziee.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "owner_house")
public class OwnerHouse implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 业主ID
     */
    @TableField(value = "owner_id")
    private Long ownerId;

    /**
     * 房屋ID
     */
    @TableField(value = "house_id")
    private Long houseId;

    /**
     * 居住类型
     */
    @TableField(value = "type_of_residence")
    private Integer typeOfResidence;

    /**
     * 迁入原因
     */
    @TableField(value = "move_in_reason")
    private String moveInReason;

    /**
     * 迁入时间
     */
    @TableField(value = "move_in_time")
    private Date moveInTime;

    /**
     * 交房时间
     */
    @TableField(value = "delivery_time")
    private Date deliveryTime;

    @TableField(value = "deleted")
    private Boolean deleted;

    @TableField(value = "gmt_create")
    private Date gmtCreate;

    @TableField(value = "gmt_modified")
    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_OWNER_ID = "owner_id";

    public static final String COL_HOUSE_ID = "house_id";

    public static final String COL_TYPE_OF_RESIDENCE = "type_of_residence";

    public static final String COL_MOVE_IN_REASON = "move_in_reason";

    public static final String COL_MOVE_IN_TIME = "move_in_time";

    public static final String COL_DELIVERY_TIME = "delivery_time";

    public static final String COL_DELETED = "deleted";

    public static final String COL_GMT_CREATE = "gmt_create";

    public static final String COL_GMT_MODIFIED = "gmt_modified";
}