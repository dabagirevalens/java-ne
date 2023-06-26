package rw.rca.next.services;

import rw.rca.next.models.Product;
import rw.rca.next.pojos.request.ProductRecordRequest;
import rw.rca.next.pojos.response.ProductResponse;

import java.util.List;

public interface ProductService {
    Product record(ProductRecordRequest productRecordRequest);

    Product getProductById(Long productId);

    Product updateProduct(Long productId, ProductRecordRequest productRecordRequest);

    boolean deleteProduct(Long productId);

    List<ProductResponse> all();
}
