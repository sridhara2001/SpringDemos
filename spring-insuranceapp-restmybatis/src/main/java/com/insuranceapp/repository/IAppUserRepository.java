package com.insuranceapp.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.insuranceapp.model.AppUser;

@Mapper
public interface IAppUserRepository {
	
	@Insert("insert into appuser values(#{user_id},#{username},#{password},#{email})")
	void addUser(AppUser appUser);
	
	@Select("select * from appuser where username=#{username}")
	AppUser findByUsername(String username);
}
