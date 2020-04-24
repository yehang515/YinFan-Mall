package com.yinfan.search.service;

import java.util.Map;

/**
 * 描述
 *
 * @author www.itheima.com
 * @version 1.0
 * @package com.changgou.search.service *
 * @since 1.0
 */
public interface SkuService {



    /**
     * //1.调用 goods微服务的fegin 查询 符合条件的sku的数据
       //2.调用spring data elasticsearch的API 导入到ES中
     */
    void  importEs();


    /**
     *条件搜索
     * @param searchMap
     * @return
     */
    Map<String, Object> search(Map<String, String> searchMap);
}
