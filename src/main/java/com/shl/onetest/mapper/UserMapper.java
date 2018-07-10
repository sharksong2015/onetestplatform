package com.shl.onetest.mapper;


import com.shl.onetest.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

	User findByName(@Param("userName") String userName);

	List<User> findUserWithDept(User user);

	//List<UserWithRole> findUserWithRole(Long userId);
	
	User findUserProfile(User user);
}