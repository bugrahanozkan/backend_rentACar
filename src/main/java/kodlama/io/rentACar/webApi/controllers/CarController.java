package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.CarService;

import kodlama.io.rentACar.business.requests.cars.CreateCarRequest;
import kodlama.io.rentACar.business.requests.cars.UpdateCarRequest;

import kodlama.io.rentACar.business.responses.cars.CreateCarResponse;
import kodlama.io.rentACar.business.responses.cars.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.cars.UpdateCarResponse;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/api/cars")
public class CarController {
	
private CarService carService;
@GetMapping("/getAll")
public List<GetAllCarsResponse> getAll(){
	return carService.getAll();
}
@PostMapping("/add")
public CreateCarResponse add(@RequestBody  CreateCarRequest createCarRequest){
	
	return this.carService.add(createCarRequest);
}

@PutMapping("/update")
public UpdateCarResponse updateBrandResponse( @RequestBody UpdateCarRequest request) {
	return this.carService.update(request);
	
}

}
