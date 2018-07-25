package com.hywa.bigdata.storage.common.redis;

/**
 * Created by Administrator on 2017-12-06.
 */


import com.google.gson.Gson;
import com.hywa.bigdata.storage.common.ContextHolderUtils;
import com.hywa.bigdata.storage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Set;

@Component
public class RedisUser {

    @Autowired
    private RedisUtil redisUtil;

    public User getUser() {
        String accessToken = ContextHolderUtils.getRequest().getParameter("accessToken");
        if (StringUtils.isEmpty(accessToken) || accessToken.length() != 32) {
            return null;
        }

        Set<String> keys = redisUtil.keys(accessToken + "*");
        if (keys == null || keys.size() != 1) {
            return null;
        }

        String jsonUser = redisUtil.get((String) keys.toArray()[0]);
        if (StringUtils.isEmpty(jsonUser)) {
            return null;
        }

        Gson gson = new Gson();
        User user = gson.fromJson(jsonUser, User.class);

        return user;
    }

}
