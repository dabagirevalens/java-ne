package rw.rca.next.pojos.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRecordRequest {
    private String productCode;
    private int quantity;
}
