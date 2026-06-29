package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Đánh dấu đây là Controller REST, nhận request từ client và trả về dữ liệu (JSON)
public class ProductController {

    // Khai báo đối tượng ProductService để sử dụng các chức năng xử lý sản phẩm
    private final ProductService productService;

    // Constructor Injection:
    // Khi Spring tạo ProductController, Spring sẽ tự truyền (inject)
    // đối tượng ProductService vào constructor này.
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Khai báo ProductService để Controller gọi xử lý logic sản phẩm
    // @Autowired // Spring tự tiêm object ProductService đã tạo sẵn vào biến này
    // private ProductService productService;
    
    // Nhận request GET từ đường dẫn /products
    // Ví dụ: http://localhost:8080/products
    @GetMapping("/products")
    public List<Product> getAllProducts() {

        // Gọi ProductService lấy danh sách sản phẩm
        // Sau đó trả kết quả về cho client dưới dạng JSON
        return productService.getAllProducts();
    }
}
