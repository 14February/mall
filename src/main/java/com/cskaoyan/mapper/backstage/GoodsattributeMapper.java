package com.cskaoyan.mapper.backstage;

import com.cskaoyan.bean.backstage.goodsbean.GoodsAttribute;
import com.cskaoyan.bean.backstage.goodsbean.GoodsAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsattributeMapper {
    long countByExample(GoodsAttributeExample example);

    int deleteByExample(GoodsAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsAttribute record);

    int insertSelective(GoodsAttribute record);

    List<GoodsAttribute> selectByExample(GoodsAttributeExample example);

    GoodsAttribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsAttribute record,@Param("example") GoodsAttributeExample example);

    int updateByExample(@Param("record") GoodsAttribute record,@Param("example") GoodsAttributeExample example);

    int updateByPrimaryKeySelective(GoodsAttribute record);

    int updateByPrimaryKey(GoodsAttribute record);
}