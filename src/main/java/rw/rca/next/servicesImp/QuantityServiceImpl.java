package rw.rca.next.servicesImp;

import org.springframework.stereotype.Service;
import rw.rca.next.models.Product;
import rw.rca.next.models.Quantity;
import rw.rca.next.pojos.request.QuantityRequest;
import rw.rca.next.repositories.ProductRepository;
import rw.rca.next.repositories.QuantityRepository;
import rw.rca.next.services.QuantityService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QuantityServiceImpl implements QuantityService {

    private final QuantityRepository quantityRepository;
    private final ProductRepository productRepository;

    public QuantityServiceImpl(QuantityRepository quantityRepository, ProductRepository productRepository) {
        this.quantityRepository = quantityRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Quantity record(QuantityRequest quantityRecordRequest) {
        // Retrieve the product by product code
        Optional<Product> productOptional = Optional.ofNullable(productRepository.findByCode(quantityRecordRequest.getCode()));
        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            // Create a new Quantity object using the product, quantity, and operation date
            Quantity quantity = new Quantity(
                    product,
                    quantityRecordRequest.getQuantity(),
                    new Date()
            );

            // Save the quantity to the database using the quantityRepository
            return quantityRepository.save(quantity);
        }
        return null;
    }

    @Override
    public List<Quantity> all() {
        return quantityRepository.findAll();
    }
}
