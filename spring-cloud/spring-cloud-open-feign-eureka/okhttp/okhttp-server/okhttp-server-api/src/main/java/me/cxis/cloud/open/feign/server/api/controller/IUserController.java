package me.cxis.cloud.open.feign.server.api.controller;

import me.cxis.cloud.open.feign.server.api.model.User;
import me.cxis.cloud.open.feign.server.api.model.common.Result;
import me.cxis.cloud.open.feign.server.api.query.UserQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IUserController {

    @GetMapping("/user/queryByUserId")
    Result<User> queryUserById(@RequestParam("userId") Long userId);

    @PostMapping("/user/queryByCondition")
    Result<User> queryByCondition(@RequestBody UserQuery query);
}
