package com.silentao.parsley.image.controller;

import com.silentao.parsley.common.vo.ParsleyResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Silence
 * @Date 2021/1/23 22:51
 **/
@RestController
public class ImageController {

    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;

    @RequestMapping("/image")
    public ParsleyResponseVO imageTest() {
        ParsleyResponseVO parsleyResponseVO = restTemplate
                .getForObject("http://PARSLEY-LOGIN/test", ParsleyResponseVO.class);

        return parsleyResponseVO;
    }
}
