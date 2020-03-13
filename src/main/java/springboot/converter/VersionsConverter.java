package springboot.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import springboot.dto.OptionsDTO;
import springboot.dto.VersionDTO;
import springboot.entity.OptionEntity;
import springboot.entity.VersionEntity;


@Component
public class VersionsConverter {
	public VersionDTO convertToDTO(VersionEntity entity) {
		ModelMapper modelMapper = new ModelMapper();
		VersionDTO dto=modelMapper.map(entity, VersionDTO.class);
		return dto;
	}
	public VersionEntity convertToEntity(VersionDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		VersionEntity entity=modelMapper.map(dto, VersionEntity.class);
		return entity;
	}
}
