package rw.rca.next.services;


import rw.rca.next.models.Purchase;
import rw.rca.next.pojos.request.PurchaseRecordRequest;

import java.util.List;

public interface PurchaseService {
    Purchase record(PurchaseRecordRequest purchaseRecordRequest);

    List<Purchase> recordMultiple(List<PurchaseRecordRequest> recordRequests);
}

