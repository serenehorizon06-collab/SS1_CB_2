package com.example.product_management.service;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // Đánh dấu đây là tầng Service (xử lý logic)
// Spring sẽ tự tạo và quản lý object ProductService (IoC)
// Spring sẽ tự làm giống như:
// ProductService productService = new ProductService();
public class ProductService {

    // Danh sách dùng để lưu các Product
    private final List<Product> products = new ArrayList<>();

    // Constructor chạy 1 lần khi Spring tạo ProductService
    public ProductService() {
        products.add(new Product(1L, "Laptop", 15000000));
        products.add(new Product(2L, "Chuột", 300000));
        products.add(new Product(3L, "Bàn phím", 700000));
    }

    // Trả về toàn bộ danh sách sản phẩm
    public List<Product> getAllProducts() {
        return products;
    }

    // Thêm sản phẩm mới
    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    // Cập nhật sản phẩm theo id
    public Product updateProduct(Long id, Product updatedProduct) {

        for (Product product : products) {

            if (product.getId().equals(id)) {

                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());

                return product;
            }
        }

        return null;
    }

    // Xóa sản phẩm theo id
    public boolean deleteProduct(Long id) {

        for (Product product : products) {

            if (product.getId().equals(id)) {

                products.remove(product);
                return true;
            }
        }

        return false;
    }
}
