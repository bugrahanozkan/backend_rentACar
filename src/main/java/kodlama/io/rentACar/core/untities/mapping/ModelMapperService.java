package kodlama.io.rentACar.core.untities.mapping;

import org.modelmapper.ModelMapper;



public interface ModelMapperService {
	ModelMapper forRequest();
	ModelMapper forResponse();
}
