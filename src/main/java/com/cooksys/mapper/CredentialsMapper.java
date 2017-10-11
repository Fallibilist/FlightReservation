/**
 * 
 */
package com.cooksys.mapper;

import org.mapstruct.Mapper;

import com.cooksys.dto.CredentialsDto;
import com.cooksys.entity.embeddable.CredentialsEmbeddable;

/**
 * @author Greg Hill
 *
 */
@Mapper(componentModel="spring")
public interface CredentialsMapper {

	CredentialsEmbeddable fromDto(CredentialsDto credentialsDto);
	
	CredentialsDto toDto(CredentialsEmbeddable credentialsEmbeddable);
	
}
