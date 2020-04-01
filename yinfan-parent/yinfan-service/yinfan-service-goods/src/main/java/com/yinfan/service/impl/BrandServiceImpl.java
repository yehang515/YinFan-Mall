package com.yinfan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yinfan.goods.pojo.Brand;
import com.yinfan.dao.BrandMapper;
import com.yinfan.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper mapper;

    /***
     * 条件+分页
     * @param brand
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Brand> findPage(Brand brand, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Brand> brands = findList(brand);
        return new PageInfo<Brand>(brands);
    }

    @Override
    public PageInfo<Brand> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Brand> brands = mapper.selectAll();
        return new PageInfo<Brand>(brands);
    }

    @Override
    public List<Brand> findList(Brand brand) {
        Example example = createExample(brand);
        return mapper.selectByExample(example);
    }

    /**
     * 条件构建
     * @param brand
     * @return
     */
    public Example createExample(Brand brand){
        //条件自定义搜索对象 Example
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria(); //条件构造器
        if(brand != null) {
            if(!StringUtils.isEmpty(brand.getName())){
                criteria.andLike("name","%" + brand.getName() + "%");
            }
            if(!StringUtils.isEmpty(brand.getLetter())) {
                criteria.andEqualTo("letter",brand.getLetter());
            }
        }
        return example;
    }

    @Override
    public List<Brand> findAll() {
        return mapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
         mapper.insertSelective(brand);
    }

    /**
     * 修改名牌
     * @param brand
     */
    @Override
    public void update(Brand brand) {
        mapper.updateByPrimaryKeySelective(brand);
    }

    /**
     *  根据ID删除
     * @param id
     */
    @Override
    public void delete(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }




}
