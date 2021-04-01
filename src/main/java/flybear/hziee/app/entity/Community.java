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
@TableName(value = "community")
public class Community implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 小区编号(C + ID，ID不满6位补0)
     */
    @TableId(value = "cno", type = IdType.INPUT)
    private String cno;

    /**
     * 小区名称
     */
    @TableField(value = "community_name")
    private String communityName;

    /**
     * 所在地区(省 市 县)
     */
    @TableField(value = "region")
    private String region;

    /**
     * 详细地址
     */
    @TableField(value = "address_detail")
    private String addressDetail;

    /**
     * 占地面积
     */
    @TableField(value = "area_covered")
    private Double areaCovered;

    /**
     * 建筑面积
     */
    @TableField(value = "floorage")
    private Double floorage;

    /**
     * 公共场所面积
     */
    @TableField(value = "area_public")
    private Double areaPublic;

    /**
     * 绿化面积
     */
    @TableField(value = "area_afforested")
    private Double areaAfforested;

    /**
     * 楼宇数量
     */
    @TableField(value = "buildings")
    private Integer buildings;

    /**
     * 客服电话
     */
    @TableField(value = "customer_service_phone")
    private String customerServicePhone;

    /**
     * 负责人姓名
     */
    @TableField(value = "person_in_charge_name")
    private String personInChargeName;

    /**
     * 负责人电话
     */
    @TableField(value = "person_in_charge_phone")
    private String personInChargePhone;

    /**
     * 小区背景图url
     */
    @TableField(value = "background_image_url")
    private String backgroundImageUrl;

    /**
     * 小区logo url
     */
    @TableField(value = "logo_url")
    private String logoUrl;

    /**
     * 管理、服务人员的工资和按规定提取的福利费
     */
    @TableField(value = "fee_welfare")
    private Double feeWelfare;

    /**
     * 物业共用部位、共用设施设备的日常运行、维护费用
     */
    @TableField(value = "fee_maintenance")
    private Double feeMaintenance;

    /**
     * 绿化管理费
     */
    @TableField(value = "fee_afforested")
    private Double feeAfforested;

    /**
     * 清洁卫生费用
     */
    @TableField(value = "fee_cleaning")
    private Double feeCleaning;

    /**
     * 保安费
     */
    @TableField(value = "fee_security")
    private Double feeSecurity;

    /**
     * 办公费
     */
    @TableField(value = "fee_office")
    private Double feeOffice;

    /**
     * 物业管理单位固定资产折旧费
     */
    @TableField(value = "fee_depreciation")
    private Double feeDepreciation;

    /**
     * 法律税收
     */
    @TableField(value = "fee_legal_taxes")
    private Double feeLegalTaxes;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 逻辑删除状态 0未删除 1已删除
     */
    @TableField(value = "deleted")
    private Boolean deleted;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_CNO = "cno";

    public static final String COL_COMMUNITY_NAME = "community_name";

    public static final String COL_REGION = "region";

    public static final String COL_ADDRESS_DETAIL = "address_detail";

    public static final String COL_AREA_COVERED = "area_covered";

    public static final String COL_FLOORAGE = "floorage";

    public static final String COL_AREA_PUBLIC = "area_public";

    public static final String COL_AREA_AFFORESTED = "area_afforested";

    public static final String COL_BUILDINGS = "buildings";

    public static final String COL_CUSTOMER_SERVICE_PHONE = "customer_service_phone";

    public static final String COL_PERSON_IN_CHARGE_NAME = "person_in_charge_name";

    public static final String COL_PERSON_IN_CHARGE_PHONE = "person_in_charge_phone";

    public static final String COL_BACKGROUND_IMAGE_URL = "background_image_url";

    public static final String COL_LOGO_URL = "logo_url";

    public static final String COL_FEE_WELFARE = "fee_welfare";

    public static final String COL_FEE_MAINTENANCE = "fee_maintenance";

    public static final String COL_FEE_AFFORESTED = "fee_afforested";

    public static final String COL_FEE_CLEANING = "fee_cleaning";

    public static final String COL_FEE_SECURITY = "fee_security";

    public static final String COL_FEE_OFFICE = "fee_office";

    public static final String COL_FEE_DEPRECIATION = "fee_depreciation";

    public static final String COL_FEE_LEGAL_TAXES = "fee_legal_taxes";

    public static final String COL_REMARK = "remark";

    public static final String COL_DELETED = "deleted";

    public static final String COL_GMT_CREATE = "gmt_create";

    public static final String COL_GMT_MODIFIED = "gmt_modified";
}