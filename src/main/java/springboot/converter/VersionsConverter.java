package springboot.converter;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import springboot.dto.VersionDTO;
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
	public List<VersionEntity> convertEntityToDTOList1( List<VersionDTO> dto){
		ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<VersionEntity>>(){}.getType();
        List<VersionEntity> postDTOList = modelMapper.map(dto, listType);
        return postDTOList;
    }
	public List<VersionDTO> convertEntityToDTOList(List<VersionEntity> dto){
		ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<VersionDTO>>(){}.getType();
        List<VersionDTO> postDTOList = modelMapper.map(dto, listType);
        return postDTOList;
    }
}
