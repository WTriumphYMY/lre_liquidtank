package cn.edu.nwpu.liquidtank.domain.po;

import javax.persistence.*;

/**
 * @ClassName LiquidTankDO
 * @Author: Trium
 * @Date: 2019/2/27 16:40
 * @Version: v1.0
 * @Description: 推进剂贮箱 输入入口流量，输出压强，体积，液体流量
 * 依据： 《002-2014200285-白晶晶》与《液体火箭增压输送系统动态特性仿真与分析_王文斌》推进剂贮箱
 */
@Entity
@Table(name = "tb_liquidtank")
public class LiquidTankPO {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer pkId;
    @Column(name = "liquidtank_name")
    private String liquidTankName;
    @Column(name = "liquidtank_liquid")
    private String liquidTankLiquid;//贮箱液体
    @Column(name = "liquidtank_v0")
    private double liquidTankV0;//气腔初始体积
    @Column(name = "liquidtank_ca")
    private double liquidTankCA;//流量系数

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getLiquidTankName() {
        return liquidTankName;
    }

    public void setLiquidTankName(String liquidTankName) {
        this.liquidTankName = liquidTankName;
    }

    public String getLiquidTankLiquid() {
        return liquidTankLiquid;
    }

    public void setLiquidTankLiquid(String liquidTankLiquid) {
        this.liquidTankLiquid = liquidTankLiquid;
    }

    public double getLiquidTankV0() {
        return liquidTankV0;
    }

    public void setLiquidTankV0(double liquidTankV0) {
        this.liquidTankV0 = liquidTankV0;
    }

    public double getLiquidTankCA() {
        return liquidTankCA;
    }

    public void setLiquidTankCA(double liquidTankCA) {
        this.liquidTankCA = liquidTankCA;
    }
}
