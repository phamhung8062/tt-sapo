package springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.converter.OptionsConverter;
import springboot.converter.ProductConverter;
import springboot.converter.VersionsConverter;
import springboot.dto.OptionsDTO;
import springboot.dto.ProductDTO;
import springboot.entity.OptionEntity;
import springboot.entity.ProductEntity;
import springboot.entity.VersionEntity;
import springboot.repository.OptionEntityRepository;
//import springboot.repository.ProductCategoryEntityRepository;
import springboot.repository.ProductEntityRepository;
import springboot.repository.VersionEntityRepository;
import springboot.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	ProductEntityRepository productrepository;

	@Autowired
	ProductConverter productconverter;

	@Autowired
	ProductEntityRepository productRepository;

	@Autowired
	VersionEntityRepository versionEntityRepository;

	@Autowired
	OptionEntityRepository optionEntityRepository;

	@Autowired
	OptionsConverter optionsConverter;

	@Autowired
	VersionsConverter versionsConverter;

	/*
	 * @Override public List<ProductDTO> findAllCustom() { List<Object[]>
	 * productEntities= productrepository.findCustom(); List<ProductDTO>
	 * productDTOs=new ArrayList<>(); for (Object[] a : productEntities) {
	 * ProductDTO b= new ProductDTO(); b.setDisplay(a[0].toString());
	 * b.setCpu(a[1].toString());
	 * 
	 * b.setImage(a[4].toString()); b.setCamera(a[5].toString());
	 * 
	 * productDTOs.add(b); } return productDTOs; }
	 */

	@Override
	public List<ProductDTO> findAll() {
		List<ProductEntity> entities = productRepository.findAll();
		List<ProductDTO> dtos = new ArrayList<>();
		for (ProductEntity productEntity : entities) {
			ProductDTO a = new ProductDTO();
			a = productconverter.convertToDTO(productEntity);
			a.setVersionDTO(versionsConverter.convertToDTO(productEntity.getVersions()));
			dtos.add(a);
		}
		return dtos;
	}

	@Override
	@Transactional
	public void save(ProductDTO dto) {
		ProductEntity entity = productconverter.convertToEntity(dto);
		checkOptions(dto.getOptions());
		if (!CheckVersion(dto.getVersionDTO().getName())) {
			System.out.println(" Phiên Bản Đã Tồn Tại");
		} else {
			VersionEntity versionEntity = versionsConverter.convertToEntity(dto.getVersionDTO());
			versionEntityRepository.save(versionEntity);
			entity.setVersions(versionEntity);

			entity = productrepository.save(entity);
			List<OptionEntity> optionEntities = optionsConverter.convertEntityToDTOList(dto.getOptions());
			for (OptionEntity optionEntity : optionEntities) {
				optionEntity.setProductEntity(entity);
				optionEntityRepository.save(optionEntity);
			}
		}
	}

	public Boolean CheckProduct(String nameversion, List<OptionsDTO> optios) {
		List<ProductEntity> entities = productRepository.findAll();
		for (ProductEntity s : entities) {
			if (s.getVersions().getName().toString().equals(nameversion)) {
				List<OptionEntity> entities2 = s.getOptions();
				if (entities2.size() == optios.size()) {
					for (OptionEntity s1 : entities2) {
						for (OptionsDTO s2 : optios) {
							if (!s1.getName().equals(s2.getName()) && !s1.getValue().equals(s2.getValue())) {
								return true;
							}
							return false;
						}
					}
				}
				return true;
			}
			return true;
		}
		return true;
	}

	public Boolean CheckVersion(String nameversion) {
		if (nameversion != null) {
			List<VersionEntity> versionEntities = versionEntityRepository.findAll();
			for (VersionEntity s : versionEntities) {
				if (s.getName().equals(nameversion)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	@Transactional
	public void update(ProductDTO dto) {
		ProductEntity entity = productconverter.convertToEntity(dto);

		VersionEntity versionEntity = versionsConverter.convertToEntity(dto.getVersionDTO());
		versionEntityRepository.save(versionEntity);
		entity.setVersions(versionEntity);

		entity = productrepository.save(entity);
		List<OptionEntity> optionEntities = optionsConverter.convertEntityToDTOList(dto.getOptions());
		for (OptionEntity optionEntity : optionEntities) {
			optionEntity.setProductEntity(entity);
			optionEntityRepository.save(optionEntity);
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		ProductEntity entity = productRepository.getOne(id);
		productrepository.deleteListOptions(id);
		productrepository.delete(entity);

	}

	@Override
	public ProductDTO findById(Long id) {
		ProductEntity entity = productrepository.getOne(id);
		ProductDTO a = new ProductDTO();
		a = productconverter.convertToDTO(entity);
		a.setVersionDTO(versionsConverter.convertToDTO(entity.getVersions()));
		return a;
	}
	
	@SuppressWarnings("unused")
	private List<OptionsDTO> checkOptions(List<OptionsDTO> options) {
        for (int i = 0; i < options.size(); i++)
            for (int j = i + 1; j < options.size(); j++) {
                if (options.get(i).getName().equals(options.get(j).getName())) {
                    options.remove(options.get(i));
                }
            }
        return options;
    }

}
