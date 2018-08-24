package com.thinkgem.jeesite.cfq.mobile.rest.utils;

public class CreateRegisterCodeUtils {

    public static String getRegisterCode() {
        String registerCode = CreateSessionId.generateSessionId();

        return registerCode.substring(0, 4);

    }

}
