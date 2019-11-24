package cn.edu.nwpu.liquidtank.controller;

import cn.edu.nwpu.liquidtank.domain.dto.LiquidTankDTO;
import cn.edu.nwpu.liquidtank.service.LiquidTankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName LiquidTankController
 * @Author: wkx
 * @Date: 2019/10/23 10:42
 * @Version: v1.0
 * @Description:
 */
@RestController
public class LiquidTankController {

    @Autowired
    private LiquidTankService liquidTankService;

    @PostMapping("liquidTankSim")
    public Map<String, List<Double>> liquidTankSim(@RequestBody LiquidTankDTO liquidTankDTO){

        return liquidTankService.liquidTankSim(liquidTankDTO);
    }

    @PostMapping("saveLiquidTank")
    public void saveLiquidTank(@RequestBody LiquidTankDTO liquidTankDTO){
        liquidTankService.saveLiquidTank(liquidTankDTO);
    }

    @PostMapping("findLiquidTankByName")
    public LiquidTankDTO findLiquidTankByName(@RequestBody String liquidTankName){
        return liquidTankService.findLiquidTankByName(liquidTankName);
    }

    @PostMapping("findAllLiquidTank")
    public List<LiquidTankDTO> findAllLiquidTank(){
        return liquidTankService.findAllLiquidTank();
    }
}
