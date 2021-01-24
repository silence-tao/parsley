package com.silentao.parsley.login.controller;

import com.silentao.parsley.common.vo.ParsleyResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Silence
 * @Date 2021/1/23 21:40
 **/
@RestController
public class LoginController {

    @RequestMapping("/test")
    public ParsleyResponseVO loginTest() {
        return ParsleyResponseVO.getSuccessInstance("Hello Eureka!");
    }
}
