package com.lance.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lance.mybatis.domain.UserInfo;

@Mapper
public interface UserMapper {
	
	@Select(value="select * from boot_user where id=#{id}")
	UserInfo getUserById(Integer id);

	@Insert(value="INSERT INTO boot_user (`name`, `tel`, `create_time`) VALUES (#{name}, #{tel}, #{createTime})")
	Integer saveUser(UserInfo userInfo);
	
	@Delete(value="DELETE FROM boot_user WHERE id = #{id}")
	Integer deleteUserById(Integer id);
	
	@Update(value="UPDATE boot_user SET `name` = #{name}, `tel` = #{tel}, `create_time` = #{createTime} WHERE  id = #{id};")
	Integer updateUserById(UserInfo userInfo);
	
	List<UserInfo> findAll();
}
