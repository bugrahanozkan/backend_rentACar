package kodlama.io.rentACar.business.requests.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
private int brandId;
 private String name;
 private double unitPrice;
 private int unitInStock;
}