package kodlama.io.rentACar.business.concretesNew;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.cars.CreateCarRequest;
import kodlama.io.rentACar.business.requests.cars.UpdateCarRequest;

import kodlama.io.rentACar.business.responses.cars.CreateCarResponse;
import kodlama.io.rentACar.business.responses.cars.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.cars.UpdateCarResponse;
import kodlama.io.rentACar.core.untities.mapping.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;

import kodlama.io.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
	private CarRepository carRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllCarsResponse> getAll() {
		List<Car> cars = carRepository.findAll();
		List<GetAllCarsResponse> carsResponse = new ArrayList<GetAllCarsResponse>();
		for (Car car : cars) {
			GetAllCarsResponse responseItem = new GetAllCarsResponse();

			responseItem.setId(car.getId());
			responseItem.setName(car.getName());
			responseItem.setUnitPrice(car.getUnitPrice());
			responseItem.setUnitInStock(car.getUnitInStock());
			
			carsResponse.add(responseItem);
		}

		return carsResponse;

	}

	@Override
	public CreateCarResponse add(CreateCarRequest createCarRequest) {
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		
		car.setId(0);

		this.carRepository.save(car);

		CreateCarResponse createCarResponse = this.modelMapperService.forResponse().map(car, CreateCarResponse.class);

		return createCarResponse;
	}

	@Override
	public UpdateCarResponse update(UpdateCarRequest updateCarRequest) {
		Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);

		this.carRepository.save(car);
		UpdateCarResponse updateCarResponse = this.modelMapperService.forResponse().map(car, UpdateCarResponse.class);

		

		return updateCarResponse;
	}

}
