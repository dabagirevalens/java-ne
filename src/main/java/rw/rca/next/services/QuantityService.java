package rw.rca.next.services;

import rw.rca.next.models.Quantity;
import rw.rca.next.pojos.request.QuantityRequest;

import java.util.List;

public interface QuantityService {
    Quantity record(QuantityRequest quantityRecordRequest);
    List<Quantity> all();
}

