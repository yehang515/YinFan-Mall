package com.yinfan.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yinfan.goods.pojo.Brand;


public interface BrandService {

    List<Brand>findList(Brand brand);
    List<Brand> findAll();
    Brand findById(Integer id);
    void add(Brand brand);
    void update(Brand brand);
    void delete(Integer id);
    PageInfo<Brand> findPage(Integer page,Integer size);
    PageInfo<Brand> findPage(Brand brand,Integer page,Integer size);
}
