package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Đánh dấu đây là Controller REST, nhận request từ client và trả về dữ liệu (JSON)
@RequestMapping("/api/products") // Đường dẫn chung cho tất cả API trong Controller này
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

    // ==========================================================
    // GET - Lấy toàn bộ danh sách sản phẩm
    // URL: http://localhost:8080/api/products
    // ==========================================================
    @GetMapping
    public List<Product> getAllProducts() {

        // Gọi ProductService lấy danh sách sản phẩm
        // Sau đó trả kết quả về cho client dưới dạng JSON
        return productService.getAllProducts();
    }

    // ==========================================================
    // POST - Thêm sản phẩm mới
    // URL: http://localhost:8080/api/products
    //
    // @RequestBody:
    // Nhận dữ liệu JSON từ Client và chuyển thành object Product
    // ==========================================================
    @PostMapping
    public Product addProduct(@RequestBody Product product) {

        // Gọi Service để thêm sản phẩm mới
        return productService.addProduct(product);
    }

    // ==========================================================
    // PUT - Cập nhật sản phẩm theo ID
    // URL: http://localhost:8080/api/products/{id}
    //
    // Ví dụ:
    // http://localhost:8080/api/products/2
    //
    // @PathVariable:
    // Lấy giá trị id từ URL
    //
    // @RequestBody:
    // Nhận thông tin sản phẩm mới từ Client
    // ==========================================================
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {

        // Gọi Service cập nhật sản phẩm
        return productService.updateProduct(id, product);
    }

    // ==========================================================
    // DELETE - Xóa sản phẩm theo ID
    // URL: http://localhost:8080/api/products/{id}
    //
    // Ví dụ:
    // http://localhost:8080/api/products/3
    //
    // @PathVariable:
    // Lấy id từ URL
    // ==========================================================
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {

        // Gọi Service để xóa sản phẩm
        boolean deleted = productService.deleteProduct(id);

        // Kiểm tra kết quả xóa
        if (deleted) {
            return "Xóa sản phẩm thành công!";
        }

        return "Không tìm thấy sản phẩm có ID = " + id;
    }

}