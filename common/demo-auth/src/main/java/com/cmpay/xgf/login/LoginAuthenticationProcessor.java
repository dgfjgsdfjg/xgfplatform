package com.cmpay.xgf.login;

import com.cmpay.lemon.common.exception.LemonException;
import com.cmpay.lemon.framework.security.SimpleUserInfo;
import com.cmpay.lemon.framework.security.UserInfoBase;
import com.cmpay.lemon.framework.security.auth.AbstractGenericMatchableAuthenticationProcessor;
import com.cmpay.lemon.framework.security.auth.GenericAuthenticationToken;
import com.cmpay.xgf.dto.UserDTO;
import com.cmpay.xgf.entity.UserDO;
import com.cmpay.xgf.enums.MsgEnum;
import com.cmpay.xgf.service.LoginService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author xgf
 */
public class LoginAuthenticationProcessor  extends AbstractGenericMatchableAuthenticationProcessor<GenericAuthenticationToken> {

   @Autowired
   private LoginService loginService;

    /**
     *
     * @param filterProcessesUrl 认证Url, 前缀必须与GenericAuthenticationFilter拦截的Url前缀一致
     */
    public LoginAuthenticationProcessor(String filterProcessesUrl) {
        super(filterProcessesUrl);
    }

    @Override
    protected UserInfoBase doProcessAuthentication(GenericAuthenticationToken genericAuthenticationToken) throws AuthenticationException {
        HttpServletRequest request = genericAuthenticationToken.getAuthenticationRequest().getHttpServletRequest();
        UserDTO userInfoDTO = bindLoginData(request);
        UserDO login = loginService.login(userInfoDTO);
        return new SimpleUserInfo(String.valueOf(login.getuId()),login.getUserName(),login.getPhone());
    }


    private UserDTO bindLoginData(HttpServletRequest request) {
        UserDTO userLoginDTO = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            InputStream is = request.getInputStream();
            userLoginDTO = objectMapper.readValue(is, UserDTO.class);
        } catch (IOException e) {
            throw LemonException.create(e);
        } catch (Exception e) {
            LemonException.throwLemonException(MsgEnum.FAIL, e.getMessage());
        }
        return userLoginDTO;
    }
}
