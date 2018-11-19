package com.fenbeitong.open.api.service.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author ivan
 * @since 2018-11-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("open_auth_info")
public class OpenAuthInfo extends Model<OpenAuthInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 公司companyID
     */
    @TableField("APP_ID")
    private String appId;

    /**
     * 公司名称
     */
    @TableField("APP_NAME")
    private String appName;

    /**
     * 生成唯一key
     */
    @TableField("APP_KEY")
    private String appKey;

    /**
     * 生成签名key
     */
    @TableField("SIGN_KEY")
    private String signKey;

    /**
     * 生成URL
     */
    @TableField("APP_URL")
    private String appUrl;

    /**
     * 1：启用，2：禁用
     */
    @TableField("APP_STATUS")
    private Integer appStatus;

    @TableField("APP_REMARK")
    private String appRemark;

    /**
     * 模块接入，1火车票，2飞机，3用车
     */
    @TableField("APP_MODEL")
    private String appModel;

    /**
     * 公司类型，如果是普通的公司则为0，如果是作为分销商或者分贝通作为供应商的公司则为1
     */
    @TableField("APP_TYPE")
    private String appType;


}
