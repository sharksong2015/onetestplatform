package com.shl.onetest.testcase;

import com.shl.onetest.base.AbstractSpringTestBase;
import com.shl.onetest.domain.User;
import com.shl.onetest.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author songhongli
 **/
public class UserTest extends AbstractSpringTestBase {
    @Autowired
    UserService userService;

    @Test
    public void test11(){
        String userName = "tester";
        User user = userService.findByName(userName);
        System.out.println(user.getUsername());
    }
}
