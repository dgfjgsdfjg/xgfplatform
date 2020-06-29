package com.cmpay.xgf.controller;

import com.cmpay.framework.data.request.GenericDTO;
import com.cmpay.lemon.common.exception.BusinessException;
import com.cmpay.lemon.framework.utils.LemonUtils;
import com.cmpay.xgf.api.CaptchaApi;
import com.cmpay.xgf.enums.MsgEnum;
import com.google.code.kaptcha.Producer;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author lihuiquan
 */
@RestController
public class CaptchaController {

    @Autowired
    private Producer producer;

//    @Resource(name = "cacheRedisTemplate")
    private RedisTemplate redisTemplate;

    /**
     * 获取验证码
     *
     * @param response
     * @param req
     */
    @GetMapping(CaptchaApi.CAPTCHA)
    public void captcha(HttpServletResponse response, GenericDTO req) {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        BufferedImage image = this.getCaptcha();
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            ImageIO.write(image, "jpg", out);
        } catch (IOException e) {
            BusinessException.throwBusinessException(MsgEnum.FAIL);
        }
        IOUtils.closeQuietly(out);

    }

    private BufferedImage getCaptcha() {
        String code = producer.createText();
        String key = LemonUtils.getApplicationName() + LemonUtils.getClientIp();
        redisTemplate.opsForValue().set(key, code, 1, TimeUnit.MINUTES);
        return producer.createImage(code);
    }

}
