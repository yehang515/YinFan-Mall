package com.yinfan.controller;


import com.github.pagehelper.PageInfo;
import com.yinfan.goods.pojo.Brand;
import com.yinfan.service.BrandService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
/**
 * 跨域  域名/端口/协议
 */
@CrossOrigin
@Api(tags = "BrandController", description = "商品品牌管理")
public class BrandController {

    @Autowired
    private BrandService service;

    @ApiOperation("分页+条件查询")
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>>findPage(@RequestBody Brand brand,
                                           @PathVariable(value = "page")Integer page,
                                           @PathVariable(value= "size")Integer size){
        PageInfo<Brand> pageInfo = service.findPage(brand,page,size);
        return new Result(true, StatusCode.OK, "查询成功", pageInfo);
    }

    @ApiOperation("分页查询")
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>>findPage(@PathVariable(value = "page")Integer page,
                                   @PathVariable(value= "size")Integer size){
        PageInfo<Brand> pageInfo = service.findPage(page,size);
        return new Result(true, StatusCode.OK, "查询成功", pageInfo);
    }

    @ApiOperation("条件查询")
    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand){
        List<Brand> brands = service.findList(brand);
        return new Result(true, StatusCode.OK, "查询成功", brands);
    }

    @ApiOperation("获取所有品牌列表")
    @GetMapping(value = "/findAll")
    public Result<List<Brand>> findAll(){
        List<Brand> brands=  service.findAll();
        return new Result(true, StatusCode.OK, "查询成功", brands);
    }

    @ApiOperation("查询指定id品牌信息")
    @GetMapping(value = "/{id}")
    public Result<Brand> findById(@PathVariable(value = "id")Integer id){
        Brand brand = service.findById(id);
        return new Result(true, StatusCode.OK,"成功",brand);
    }

    @ApiOperation("添加品牌")
    @PostMapping
    public Result add(@RequestBody Brand brand){
        service.add(brand);
        return new Result();
    }

    @ApiOperation("更新指定id品牌信息")
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable(value = "id")Integer id, @RequestBody Brand brand){
        brand.setId(id);
        service.update(brand);
        return new Result();
    }

    @ApiOperation("删除ID")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id")Integer id){
        service.delete(id);
        return new Result();
    }



}
