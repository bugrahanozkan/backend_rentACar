package kodlama.io.rentACar.webApi.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.brands.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.brands.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brands.CreateBrandResponse;
import kodlama.io.rentACar.business.responses.brands.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.brands.UpdateBrandResponse;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;



@AllArgsConstructor
@RestController
@RequestMapping("/api/brands")

public class BrandsController {
private BrandService brandService;

@GetMapping("/getAll")
 public List<GetAllBrandsResponse> getAll(){
	 return brandService.getAll();
 }

@PostMapping("/add")
public CreateBrandResponse add(@RequestBody CreateBrandRequest createBrandRequest) {
	
	return brandService.add(createBrandRequest);
}

@PutMapping("/update")
public UpdateBrandResponse updateBrandResponse(@RequestBody   UpdateBrandRequest request) {
	return this.brandService.update(request);
	
}



	
	
}
