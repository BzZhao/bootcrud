package com.bootcrud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "gongcan")
public class Gongcan {
    @TableField(value = "id")
    private String gcid;

    /**
     * 开通日期
     */
    @TableField(value = "kaitongriqi")
    private String kaitongriqi;

    /**
     * 生产厂家
     */
    @TableField(value = "shebeichangjia")
    private String shebeichangjia;

    @TableField(value = "zhishi")
    private String zhishi;

    @TableField(value = "wangguan")
    private String wangguan;

    @TableField(value = "mcc")
    private String mcc;

    @TableField(value = "mnc")
    private String mnc;

    @TableField(value = "tac")
    private String tac;

    @TableField(value = "wangyuanid")
    private String wangyuanid;

    @TableField(value = "enb_id")
    private String enbId;

    @TableField(value = "ziwang")
    private String ziwang;

    @TableField(value = "enb_name")
    private String enbName;

    @TableField(value = "changjia")
    private String changjia;

    @TableField(value = "quyv")
    private String quyv;

    @TableField(value = "lonb")
    private Double lonb;

    @TableField(value = "latb")
    private Double latb;

    @TableField(value = "xiaoquhao")
    private String xiaoquhao;

    @TableField(value = "cell_id")
    private String cellId;

    /**
     * 460-00-enodeb-ci
     */
    @TableField(value = "eci")
    private String eci;

    @TableField(value = "cell_name")
    private String cellName;

    @TableField(value = "shudichangjia")
    private String shudichangjia;

    @TableField(value = "rru_id")
    private String rruId;

    /**
     * 是否支持电调，状态1：支持
     */
    @TableField(value = "zhichidiantiao")
    private String zhichidiantiao;

    @TableField(value = "cellgonglv")
    private String cellgonglv;

    @TableField(value = "pinduanzhishi")
    private String pinduanzhishi;

    @TableField(value = "sxzhongxinpindian")
    private String sxzhongxinpindian;

    @TableField(value = "xxzhongxinpindian")
    private String xxzhongxinpindian;

    @TableField(value = "pindianhao")
    private String pindianhao;

    @TableField(value = "daikuan")
    private String daikuan;

    @TableField(value = "fugaileixing")
    private String fugaileixing;

    @TableField(value = "lonc")
    private Double lonc;

    @TableField(value = "latc")
    private Double latc;

    @TableField(value = "pci")
    private String pci;

    @TableField(value = "mod3")
    private String mod3;

    /**
     * 方位角
     */
    @TableField(value = "Azimuth")
    private String azimuth;

    /**
     * 机械下倾
     */
    @TableField(value = "mtilt")
    private String mtilt;

    /**
     * 电子下倾
     */
    @TableField(value = "etilt")
    private String etilt;

    /**
     * 总下倾角
     */
    @TableField(value = "zongxiaqingjiao")
    private String zongxiaqingjiao;

    /**
     * 站高
     */
    @TableField(value = "anthigh")
    private String anthigh;

    /**
     * 根序列
     */
    @TableField(value = "genxulie")
    private String genxulie;

    /**
     * 开通状态
     */
    @TableField(value = "zhuangtai")
    private String zhuangtai;

    /**
     * 网元ip地址
     */
    @TableField(value = "wangyuanip")
    private String wangyuanip;

    /**
     * 场景：农村、乡镇...
     */
    @TableField(value = "changjing")
    private String changjing;

    /**
     * 物理站名
     */
    @TableField(value = "wulizhanming")
    private String wulizhanming;
}