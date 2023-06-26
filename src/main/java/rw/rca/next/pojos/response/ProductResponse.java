package rw.rca.next.pojos.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductResponse {
    private String code;
    private String name;
    private String type;
    private double price;
    private Long quantity;
    private Long quantity_id;


}
