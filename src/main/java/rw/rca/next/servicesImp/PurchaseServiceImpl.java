package rw.rca.next.servicesImp;

import org.springframework.stereotype.Service;
import rw.rca.next.models.Product;
import rw.rca.next.models.Purchase;
import rw.rca.next.models.Report;
import rw.rca.next.pojos.request.PurchaseRecordRequest;
import rw.rca.next.repositories.ProductRepository;
import rw.rca.next.repositories.PurchaseRepository;
import rw.rca.next.repositories.ReportRepository;
import rw.rca.next.services.PurchaseService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;
    private final ReportRepository reportRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, ProductRepository productRepository, ReportRepository reportRepository) {
        this.purchaseRepository = purchaseRepository;
        this.productRepository = productRepository;
        this.reportRepository = reportRepository;
    }

    @Override
    public Purchase record(PurchaseRecordRequest purchaseRecordRequest) {
        // Retrieve the product by product code
        Optional<Product> productOptional = Optional.ofNullable(productRepository.findByCode(purchaseRecordRequest.getProductCode()));
        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            // Calculate the total price
            double totalPrice = product.getPrice() * purchaseRecordRequest.getQuantity();

            // Create a new Purchase object using the product, quantity, total price, and date
            Purchase purchase = new Purchase(
                    product,
                    purchaseRecordRequest.getQuantity(),
                    totalPrice,
                    LocalDate.now()
            );

            // Save the purchase to the database using the purchaseRepository
            return purchaseRepository.save(purchase);
        }
        return null;
    }

    @Override
    public List<Purchase> recordMultiple(List<PurchaseRecordRequest> recordRequests) {
        List<Purchase> purchases = new ArrayList<>();

        for (PurchaseRecordRequest purchaseRecordRequest : recordRequests) {
            // Retrieve the product by product code
            Optional<Product> productOptional = Optional.ofNullable(productRepository.findByCode(purchaseRecordRequest.getProductCode()));
            if (productOptional.isPresent()) {
                Product product = productOptional.get();

                // Calculate the total price
                double totalPrice = product.getPrice() * purchaseRecordRequest.getQuantity();

                // Create a new Purchase object using the product, quantity, total price, and date
                Purchase purchase = new Purchase(
                        product,
                        purchaseRecordRequest.getQuantity(),
                        totalPrice,
                        LocalDate.now()
                );

                // Save the purchase to the database using the purchaseRepository
                Purchase savedPurchase = purchaseRepository.save(purchase);
                purchases.add(savedPurchase);
            }
        }
        return purchases;
    }


}
