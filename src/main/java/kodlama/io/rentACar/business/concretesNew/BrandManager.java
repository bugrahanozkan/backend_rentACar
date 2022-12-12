package kodlama.io.rentACar.business.concretesNew;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.untities.mapping.ModelMapperService;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.brands.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.brands.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brands.CreateBrandResponse;
import kodlama.io.rentACar.business.responses.brands.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.brands.UpdateBrandResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
		for (Brand brand : brands) {
			/*GetAllBrandsResponse responseItem = new GetAllBrandsResponse();

			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			brandsResponse.add(responseItem);*/
			GetAllBrandsResponse responseItem =modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class);
			brandsResponse.add(responseItem);
		}

		return brandsResponse;

	}

	@Override
	public CreateBrandResponse add(CreateBrandRequest createBrandRequest) {

		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

		this.brandRepository.save(brand);

		CreateBrandResponse createBrandResponse = this.modelMapperService.forResponse().map(brand,
				CreateBrandResponse.class);

		return createBrandResponse;
	}

	@Override
	public UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest) {

		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);

		brand.setId(updateBrandRequest.getId());

		this.brandRepository.save(brand);
		
		UpdateBrandResponse updateBrandResponse = this.modelMapperService.forResponse().map(brand,
				UpdateBrandResponse.class);

		return updateBrandResponse;
	}

}
