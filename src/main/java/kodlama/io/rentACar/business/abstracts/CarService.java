package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.cars.CreateCarRequest;
import kodlama.io.rentACar.business.requests.cars.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.cars.CreateCarResponse;
import kodlama.io.rentACar.business.responses.cars.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.cars.UpdateCarResponse;

public interface CarService {
	List<GetAllCarsResponse> getAll();

	CreateCarResponse add(CreateCarRequest createCarRequest);

	UpdateCarResponse update(UpdateCarRequest createCarRequest);
}
