package com.store.model.product;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.productConverter = new ProductConverter();
    }

    public List<ProductDto> getProducts(){
        List<Product> products = productRepository.findAll();
        return productConverter.convertAllToDto(products);
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public ProductDto saveProduct(ProductDto productDto){
        return productConverter.entityToDto(productRepository.save(productConverter.dtoToEntity(productDto)));
    }

    public Map<String, String> uploadImage(MultipartFile file) throws IOException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "verdoux",
                "api_key", "677878282762623",
                "api_secret", "qbzuQ9ZE19e8w4y1RDuFzXOMqOI"));

        Map upload = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        Map<String, String> jsonMap = new HashMap<>();
        jsonMap.put("content", upload.get("url").toString());
        return jsonMap;
    }

    public ProductDto entityToDto(Product product){
        return productConverter.entityToDto(product);

    }

}
