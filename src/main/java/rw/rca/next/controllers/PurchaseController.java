package rw.rca.next.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.rca.next.models.Purchase;
import rw.rca.next.pojos.request.PurchaseRecordRequest;
import rw.rca.next.services.PurchaseService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody PurchaseRecordRequest purchaseRecordRequest) {
        Purchase createdPurchase = purchaseService.record(purchaseRecordRequest);
        if (createdPurchase != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPurchase);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/order")
    public String buy(@RequestBody List<PurchaseRecordRequest> purchaseRecordRequests) {
        List<Purchase> createdPurchases = purchaseService.recordMultiple(purchaseRecordRequests);
        if (!createdPurchases.isEmpty()) {
            return "Order Placed successfully.";
        } else {
            return "Something went Wrong";
        }
    }
}
