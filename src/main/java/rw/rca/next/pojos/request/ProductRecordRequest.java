package rw.rca.next.pojos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRecordRequest {
    @NotNull
    private String code;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private Double price;

    @NotNull
    private Date inDate;

}
