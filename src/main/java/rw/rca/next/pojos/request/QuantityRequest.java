package rw.rca.next.pojos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rw.rca.next.models.Product;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuantityRequest {
    @NotNull
    private String code;

    @NotNull
    private Long quantity;

    @NotNull
    private LocalDate date;
}
