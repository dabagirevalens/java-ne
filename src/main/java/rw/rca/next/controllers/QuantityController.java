package rw.rca.next.controllers;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.rca.next.models.Quantity;
import rw.rca.next.pojos.request.QuantityRequest;
import rw.rca.next.services.QuantityService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quantities")
public class QuantityController {

    private final QuantityService quantityService;

    public QuantityController(QuantityService quantityService) {
        this.quantityService = quantityService;
    }

    @PostMapping
    public ResponseEntity<Quantity> createQuantity(@RequestBody QuantityRequest quantityRecordRequest) {
        Quantity createdQuantity = quantityService.record(quantityRecordRequest);
        if (createdQuantity != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdQuantity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Quantity>> all(){
        return ResponseEntity.ok().body(quantityService.all());
    }
}
