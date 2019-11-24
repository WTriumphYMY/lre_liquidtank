package cn.edu.nwpu.liquidtank.repository;

import cn.edu.nwpu.liquidtank.domain.po.LiquidTankPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @InterfaceName LiquidTankRepository
 * @Author: wkx
 * @Date: 2019/10/26 10:26
 * @Version: v1.0
 * @Description:
 */
@Repository
public interface LiquidTankRepository extends JpaRepository<LiquidTankPO, Integer> {
    LiquidTankPO findByLiquidTankName(String liquidTankName);

    List<LiquidTankPO> findAll();
}
