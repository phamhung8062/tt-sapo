package springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.converter.OptionsConverter;
import springboot.converter.ProductConverter;
import springboot.converter.VersionsConverter;
import springboot.dto.ProductDTO;
import springboot.entity.OptionEntity;
import springboot.entity.ProductEntity;
import springboot.entity.VersionEntity;
import springboot.repository.OptionEntityRepository;
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
	VersionEntityRepository versionEntityRepository;

	@Autowired
	OptionEntityRepository optionEntityRepository;

	@Autowired
	OptionsConverter optionsConverter;

	@Autowired
	VersionsConverter versionsConverter;

	@Override
	public List<ProductDTO> findAll() {
		List<ProductEntity> entities = productrepository.findAll();
		List<ProductDTO> dtos = new ArrayList<>();
		for (ProductEntity productEntity : entities) {
			ProductDTO a = new ProductDTO();
			a = productconverter.convertToDTO(productEntity);
			a.setVersion(versionsConverter.convertEntityToDTOList(productEntity.getVersions()));
			dtos.add(a);
		}
		return dtos;
	}

	@Override
	@Transactional
	public void save(ProductDTO dto) {
		ProductEntity entity = productconverter.convertToEntity(dto);
		if (!checkProduct(entity.getName())) {
			System.out.println("Sản phẩm đã tồn tại trong kho !");
		} else {
			List<VersionEntity> versionEntity = versionsConverter.convertEntityToDTOList1( dto.getVersion());
			for ( VersionEntity version : versionEntity) {
				if (!CheckVersion(version.getName().toString())) {
					System.out.println("Đã tồn tại phiên bản");
				} else {
					entity=productrepository.save(entity);
					version.setProducts(entity);
					versionEntityRepository.save(version);
					List<OptionEntity> optionEntities = checkOptions(version.getOptions());
					for (OptionEntity optionEntity : optionEntities) {
						optionEntity.setVersion(version);
						optionEntityRepository.save(optionEntity);
					}
				}
			}
		}
	}

	@Override
	@Transactional
	public void update(ProductDTO dto) {
		ProductEntity entity = productconverter.convertToEntity(dto);
		List<VersionEntity> versionEntity = versionsConverter.convertEntityToDTOList1(dto.getVersion());
		for (VersionEntity version : versionEntity) {
			if (!CheckVersion(version.getName().toString())) {
				System.out.println("Đã tồn tại phiên bản");
				entity = productrepository.save(entity);
				updateOption(checkOptions(version.getOptions()), version);
			} else {
				version.setProducts(entity);
				version=versionEntityRepository.save(version);
				updateOption(checkOptions(version.getOptions()), version);
			}
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		ProductEntity entity = productrepository.getOne(id);
		for (VersionEntity versionEntity : entity.getVersions()) {
			for(OptionEntity op:versionEntity.getOptions()) {
				optionEntityRepository.delete(op);
			}
			versionEntityRepository.delete(versionEntity);
		}
		productrepository.delete(entity);

	}

	@Override
	public ProductDTO findById(Long id) {
		ProductEntity entity = productrepository.getOne(id);
		ProductDTO a = new ProductDTO();
		a = productconverter.convertToDTO(entity);
		a.setVersion(versionsConverter.convertEntityToDTOList(entity.getVersions()));
		return a;
	}

	public Boolean CheckVersionupdate(List<VersionEntity> productEntity, String nameversion) {
		for (VersionEntity s : productEntity) {
			if (s.getName().equals(nameversion)) {
				return false;
			}
		}
		return true;
	}

	public Boolean CheckVersion(String nameversion) {
		List<ProductEntity> productEntity = productrepository.findAll();
		for (ProductEntity product : productEntity) {
			for (VersionEntity s : product.getVersions()) {
				if (s.getName().equals(nameversion)) {
					return false;
				}
			}
		}
		return true;
	}

	private List<OptionEntity> checkOptions(List<OptionEntity> options) {
		for (int i = 0; i < options.size(); i++)
			for (int j = i + 1; j < options.size(); j++) {
				if (options.get(i).getName().equals(options.get(j).getName())) {
					options.remove(options.get(i));
				}
			}
		return options;
	}

	private Boolean checkProduct(String nameProduct) {
		List<ProductEntity> productEntities = productrepository.findAll();
		for (ProductEntity pro : productEntities) {
			if (pro.getName().equals(nameProduct))
				return false;
		}
		return true;
	}

	private void updateOption(List<OptionEntity> optionEntities, VersionEntity version) {
		for (OptionEntity optionEntity : optionEntities) {
			optionEntity.setVersion(version);
			optionEntityRepository.save(optionEntity);
		}
	}
}
