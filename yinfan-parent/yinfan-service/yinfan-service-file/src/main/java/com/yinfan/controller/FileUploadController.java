package com.yinfan.controller;

import com.yinfan.file.FastDFSFile;
import com.yinfan.util.FastDFSUtil;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@RequestMapping(value = "/upload")
@CrossOrigin
@Api(tags = "FileUploadController", description = "文件操作")
public class FileUploadController {

    /**
     * 文件上传
     */
    @PostMapping(value="/file")
    @ApiOperation("文件上传")
    public Result upload(MultipartHttpServletRequest request) throws Exception {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile file = req.getFile("Activate Hotspot mode_1.png");
        //封装文件 信息
        FastDFSFile fastDFSFile = new FastDFSFile(
                file.getOriginalFilename(), //文件名字
                file.getBytes(),  //文件字节数组
                StringUtils.getFilenameExtension(file.getOriginalFilename())); //获取文件扩展名

        //调用FastDfSUtil工具类传入到FastDFS中
        String[] uploads = FastDFSUtil.upload(fastDFSFile);

        //拼接访问地址 url = http://192.168.177.59:8080/
        String url = FastDFSUtil.getTrackerInfo() + "/" + uploads[0] + "/"+ uploads[1];

        return new Result(true, StatusCode.OK, "上传成功!", url);

    }
}
