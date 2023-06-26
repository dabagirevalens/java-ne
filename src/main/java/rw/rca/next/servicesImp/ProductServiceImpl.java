package rw.rca.next.servicesImp;

import org.springframework.stereotype.Service;
import rw.rca.next.models.Product;
import rw.rca.next.models.Quantity;
import rw.rca.next.pojos.request.ProductRecordRequest;
import rw.rca.next.pojos.response.ProductResponse;
import rw.rca.next.repositories.ProductRepository;
import rw.rca.next.repositories.QuantityRepository;
import rw.rca.next.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final QuantityRepository quantityRepository;

    public ProductServiceImpl(ProductRepository productRepository, QuantityRepository quantityRepository){
        this.productRepository = productRepository;
        this.quantityRepository = quantityRepository;
    }

    @Override
    public Product record(ProductRecordRequest productRecordRequest) {
        // Create a new Product object using the data from the productRecordRequest
        Product product = new Product(
                productRecordRequest.getCode(),
                productRecordRequest.getName(),
                productRecordRequest.getType(),
                productRecordRequest.getPrice(),
                productRecordRequest.getInDate()
        );

        // Save the product to the database using the productRepository
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long productId) {
        // Retrieve a product by its ID using the productRepository
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.orElse(null);
    }

    @Override
    public Product updateProduct(Long productId, ProductRecordRequest productRecordRequest) {
        // Retrieve the existing product by its ID
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            // Update the product with the new data
            product.setCode(productRecordRequest.getCode());
            product.setName(productRecordRequest.getName());
            product.setType(productRecordRequest.getType());
            product.setPrice(productRecordRequest.getPrice());
            product.setInDate(productRecordRequest.getInDate());

            // Save the updated product to the database
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        // Check if the product exists
        if (productRepository.existsById(productId)) {
            // Delete the product from the database
            productRepository.deleteById(productId);
            return true;
        }
        return false;
    }

    @Override
    public List<ProductResponse> all() {
        List<ProductResponse> productList = new ArrayList<>();

        List<Product> products = productRepository.findAll();

        for (Product product : products) {
            Quantity quantity = findQuantityForProduct(product); // Retrieve the quantity for the product code
            ProductResponse productResponse = new ProductResponse(
                    product.getCode(),
                    product.getName(),
                    product.getType(),
                    product.getPrice(),
                    quantity.getQuantity(), // Set the retrieved quantity
                    quantity.getId()
            );
            productList.add(productResponse);
        }

        return productList;
    }

    // Helper method to find the quantity for a given product code
    private Quantity findQuantityForProduct(Product product) {

        return quantityRepository.getQuantityByProduct(product);
    }

}
