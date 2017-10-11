/**
 * 
 */
package com.cooksys.mapper;

import org.mapstruct.Mapper;
import com.cooksys.dto.UserSaveDto;
import com.cooksys.entity.UserEntity;

/**
 * @author Greg Hill
 *
 */
@Mapper(componentModel="spring", uses={ CredentialsMapper.class })
public interface UserMapper {
	
	UserEntity fromDtoSave(UserSaveDto userSaveDto);
	
}
