package cn.edu.nwpu.liquidtank.service;


import cn.edu.nwpu.liquidtank.domain.dto.LiquidTankDTO;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName ConstDualSystemService
 * @Author: wkx
 * @Date: 2019/7/20 10:04
 * @Version: v1.0
 * @Description: 液发仿真接口
 */
public interface LiquidTankService {

    /**
     *
     * @param liquidTankDTO
     * @return 液体贮箱仿真
     */
    Map<String, List<Double>> liquidTankSim(LiquidTankDTO liquidTankDTO);

    void saveLiquidTank(LiquidTankDTO liquidTankDTO);

    LiquidTankDTO findLiquidTankByName(String liquidTankName);

    List<LiquidTankDTO> findAllLiquidTank();
}
