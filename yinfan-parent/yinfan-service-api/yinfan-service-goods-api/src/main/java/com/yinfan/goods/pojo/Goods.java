package com.yinfan.goods.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 商品信息组合
 * List<Sku>
 *
 */
public class Goods implements Serializable {
    //spu信息
    private Spu spu;

    //Sku集合信息
    private List<Sku> skuList;

    @Override
    public String toString() {
        return "Goods{" +
                "spu=" + spu +
                ", skuList=" + skuList +
                '}';
    }

    public Spu getSpu() {
        return spu;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }
}
