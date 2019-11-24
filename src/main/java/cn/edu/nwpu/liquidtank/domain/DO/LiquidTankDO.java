package cn.edu.nwpu.liquidtank.domain.DO;

import cn.edu.nwpu.liquidtank.domain.DO.GasData.GasData;
import cn.edu.nwpu.liquidtank.domain.DO.LiquidData.LiquidData;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LiquidTankDO
 * @Author: Trium
 * @Date: 2019/2/27 16:40
 * @Version: v1.0
 * @Description: 推进剂贮箱 输入入口流量，输出压强，体积，液体流量
 * 依据： 《002-2014200285-白晶晶》与《液体火箭增压输送系统动态特性仿真与分析_王文斌》推进剂贮箱
 */
public class LiquidTankDO {

    private LiquidData liquidData;//贮箱液体
    private GasData gasData;//挤压气体
    private double k;//挤压气体比热比
    private double v0;//气腔初始体积
    private double rho_l;//推进剂密度
    private double CA;//流量系数
    private double p0; //初始压强

    private List<Double> p = new ArrayList<>();//压强，Pa
    private List<Double> rho = new ArrayList<>();//密度
    private List<Double> q = new ArrayList<>();//质量流率，kg/s
    private List<Double> v = new ArrayList<>();//气腔体积，kg/s


    public LiquidTankDO(LiquidData liquidData, GasData gasData) {
        this.liquidData = liquidData;
        this.gasData = gasData;
        k = gasData.getKappa();
        rho_l = liquidData.getRho();
    }

    public LiquidData getLiquidData() {
        return liquidData;
    }

    public void setLiquidData(LiquidData liquidData) {
        this.liquidData = liquidData;
    }

    public GasData getGasData() {
        return gasData;
    }

    public void setGasData(GasData gasData) {
        this.gasData = gasData;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getV0() {
        return v0;
    }

    public void setV0(double v0) {
        this.v0 = v0;
    }

    public double getRho_l() {
        return rho_l;
    }

    public void setRho_l(double rho_l) {
        this.rho_l = rho_l;
    }

    public double getP0() {
        return p0;
    }

    public void setP0(double p0) {
        this.p0 = p0;
    }

    public double getCA() {
        return CA;
    }

    public void setCA(double CA) {
        this.CA = CA;
    }
}
