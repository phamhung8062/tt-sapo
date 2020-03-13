package springboot.converter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import springboot.dto.OptionsDTO;
import springboot.entity.OptionEntity;


@Component
public class OptionsConverter {
	public OptionsDTO convertToDTO(OptionEntity entity) {
		ModelMapper modelMapper = new ModelMapper();
		OptionsDTO dto=modelMapper.map(entity, OptionsDTO.class);
		return dto;
	}
	public OptionEntity convertToEntity(OptionsDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		OptionEntity entity=modelMapper.map(dto, OptionEntity.class);
		return entity;
	}
	public  List<OptionEntity> jsonToSlaveEntity(List<?> json) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
           return objectMapper.readValue(
                   (JsonParser) json,
                objectMapper.getTypeFactory().constructCollectionType(List.class, OptionEntity.class)
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<OptionEntity>();
    }
	public List<OptionEntity> convertEntityToDTOList(List<OptionsDTO> dto){
		ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<OptionEntity>>(){}.getType();
        List<OptionEntity> postDTOList = modelMapper.map(dto, listType);
        return postDTOList;
    }
}
