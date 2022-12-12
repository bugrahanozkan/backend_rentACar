package kodlama.io.rentACar.business.responses.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateCarResponse {
private int id;
private int brandId;
private String name;
private double unitPrice;
private int unitInStock;
}
