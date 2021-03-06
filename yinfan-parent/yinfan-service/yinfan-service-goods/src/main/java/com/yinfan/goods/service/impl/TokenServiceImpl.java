package com.yinfan.goods.service.impl;

import com.yinfan.goods.service.TokenService;
import org.apache.commons.lang.text.StrBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisService redisService;


    /**
     * 创建token
     *
     * @return
     */
    @Override
    public String createToken() {

        String str = "14535265342522435234";
        StrBuilder token = new StrBuilder();
        try {
            token.append("TOKEN_PREFIX").append(str);
            redisService.setEx(token.toString(), token.toString(),10000L);
//            boolean notEmpty = StrUtil.isNotEmpty(token.toString());
//            if (notEmpty) {
                return token.toString();
         //   }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    /**
     * 检验token
     *
     * @param request
     * @return
     */
    @Override
    public boolean checkToken(HttpServletRequest request) throws Exception {

        String token = request.getHeader("TOKEN_NAME");
        if (token == null ) {// header中不存在token
            token = request.getParameter("TOKEN_NAME");
            //if (StrUtil.isBlank(token)) {// parameter中也不存在token
              //  throw new ServiceException(Constant.ResponseCode.ILLEGAL_ARGUMENT, 100);
           // }
        }

//        if (!redisService.exists(token)) {
//            throw new ServiceException(Constant.ResponseCode.REPETITIVE_OPERATION, 200);
//        }

        boolean remove = redisService.remove(token);
        if (!remove) {
            throw new Exception();
          //  throw new ServiceException(Constant.ResponseCode.REPETITIVE_OPERATION, 200);
        }
        return true;
    }
}
