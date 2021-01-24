package com.silentao.parsley.base.controller;

import com.silentao.parsley.common.vo.ParsleyResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Silence
 * @Date 2021/1/23 22:51
 **/
@RestController
public class ImageController {

    @RequestMapping("/image")
    public ParsleyResponseVO imageTest() {

        return ParsleyResponseVO.getSuccessInstance();
    }
}
