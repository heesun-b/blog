package shop.mtcoding.blog.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import shop.mtcoding.blog.dto.user.UserRequestDto.JoinRequestDto;

@Mapper
public interface UserRepository {

    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    public int insert(JoinRequestDto joinRequestDto);
}
