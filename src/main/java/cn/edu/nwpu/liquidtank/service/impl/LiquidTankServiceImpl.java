package cn.edu.nwpu.liquidtank.service.impl;


import cn.edu.nwpu.liquidtank.algorithm.calculate.LiquidTankCalc;
import cn.edu.nwpu.liquidtank.domain.DO.GasData.GasData;
import cn.edu.nwpu.liquidtank.domain.DO.GasData.N2GasData;
import cn.edu.nwpu.liquidtank.domain.DO.LiquidData.LiquidData;
import cn.edu.nwpu.liquidtank.domain.DO.LiquidTankDO;
import cn.edu.nwpu.liquidtank.domain.dto.LiquidTankDTO;
import cn.edu.nwpu.liquidtank.domain.po.LiquidTankPO;
import cn.edu.nwpu.liquidtank.factory.MediumFactory;
import cn.edu.nwpu.liquidtank.repository.LiquidTankRepository;
import cn.edu.nwpu.liquidtank.service.LiquidTankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName ConstDualSystemServiceImpl
 * @Author: wkx
 * @Date: 2019/7/20 10:04
 * @Version: v1.0
 * @Description: 液发仿真实现
 */
@Service
public class LiquidTankServiceImpl implements LiquidTankService {

    @Autowired
    private LiquidTankRepository liquidTankRepository;

    @Override
    public Map<String, List<Double>> liquidTankSim(LiquidTankDTO liquidTankDTO) {
//        double calTime = Double.parseDouble(liquidTankDTO.getGlobalParasTime());
//        double timeStep = Double.parseDouble(liquidTankDTO.getGlobalParasStep());
//
//        LiquidTankDO liquidTank = transformDTOtoDO(liquidTankDTO);
//
//        LiquidTankCalc liquidTankCalc = new LiquidTankCalc(liquidTank);
//        liquidTankCalc.setH(timeStep);
//        double pin = Double.parseDouble(liquidTankDTO.getPin());
//        double pe = Double.parseDouble(liquidTankDTO.getPe());
//
//        double time = 0.0;
//        List<Double> t = new ArrayList<>();
//        t.add(time);
//        while (time < calTime){
//            liquidTankCalc.execute(pin, new N2GasData().getRho(),pe);
//            time += timeStep;
//            t.add(time);
//        }
//        Map<String, List<Double>> resultMap = new HashMap<>();
//        resultMap.put("t", t);
//        resultMap.put("p", liquidTankCalc.getP());
//        resultMap.put("q", liquidTankCalc.getQ());
//        resultMap.put("rho", liquidTankCalc.getRho());
//        resultMap.put("v", liquidTankCalc.getV());
        return null;
    }

    @Override
    public void saveLiquidTank(LiquidTankDTO liquidTankDTO) {
        LiquidTankPO liquidTankPO = transformDTOtoPO(liquidTankDTO);
        liquidTankRepository.save(liquidTankPO);
    }

    @Override
    public LiquidTankDTO findLiquidTankByName(String liquidTankName) {
        LiquidTankPO liquidTankPO = liquidTankRepository.findByLiquidTankName(liquidTankName);
        LiquidTankDTO liquidTankDTO = transformPOtoDTO(liquidTankPO);
        return liquidTankDTO;
    }

    private LiquidTankDTO transformPOtoDTO(LiquidTankPO liquidTankPO) {
        LiquidTankDTO liquidTankDTO = new LiquidTankDTO();
        liquidTankDTO.setFuelTankFuel(liquidTankPO.getLiquidTankLiquid());
        liquidTankDTO.setFuelTankCA(String.valueOf(liquidTankPO.getLiquidTankCA()));
        liquidTankDTO.setFuelTankV0(String.valueOf(liquidTankPO.getLiquidTankV0()));
        liquidTankDTO.setComponentName(liquidTankPO.getLiquidTankName());
        return liquidTankDTO;
    }

    @Override
    public List<LiquidTankDTO> findAllLiquidTank() {
        List<LiquidTankDTO> liquidTankDTOList = new ArrayList<>();
        List<LiquidTankPO> liquidTankPOList = liquidTankRepository.findAll();
        for (LiquidTankPO liquidTankPO : liquidTankPOList) {
            liquidTankDTOList.add(transformPOtoDTO(liquidTankPO));
        }
        return liquidTankDTOList;
    }

    private LiquidTankPO transformDTOtoPO(LiquidTankDTO liquidTankDTO) {
        LiquidTankPO liquidTankPO = new LiquidTankPO();
        liquidTankPO.setLiquidTankLiquid(liquidTankDTO.getFuelTankFuel());
        liquidTankPO.setLiquidTankCA(Double.parseDouble(liquidTankDTO.getFuelTankCA()));
        liquidTankPO.setLiquidTankV0(Double.parseDouble(liquidTankDTO.getFuelTankV0()));
        liquidTankPO.setLiquidTankName(liquidTankDTO.getComponentName());
        return liquidTankPO;
    }


    private LiquidTankDO transformDTOtoDO(LiquidTankDTO liquidTankDTO) {
        GasData gasData = MediumFactory.getGasData(liquidTankDTO.getBottleGas());
        LiquidData liquidData = MediumFactory.getLiquidData(liquidTankDTO.getFuelTankFuel());
        LiquidTankDO liquidTankDO = new LiquidTankDO(liquidData, gasData);
        liquidTankDO.setCA(Double.parseDouble(liquidTankDTO.getFuelTankCA()));
        liquidTankDO.setV0(Double.parseDouble(liquidTankDTO.getFuelTankV0()));
        liquidTankDO.setP0(Double.valueOf(liquidTankDTO.getFuelTankPressure()));
        return liquidTankDO;
    }


}
