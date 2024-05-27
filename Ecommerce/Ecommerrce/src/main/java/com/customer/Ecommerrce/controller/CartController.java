package com.customer.Ecommerrce.controller;

import com.customer.Ecommerrce.dto.CartRequest;
import com.customer.Ecommerrce.service.impl.CartService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cart")
public class CartController {
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;
    @Transactional
    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody CartRequest cartRequest) {
        cartService.addToCart(cartRequest.getUsername(), cartRequest.getBreedVariety(), cartRequest.getBreedName());
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"success\"}");
    }

//    @PostMapping("/remove")
//    public ResponseEntity<String> removeFromCart(@RequestBody CartRequest cartRequest) {
//        cartService.removeFromCart(cartRequest.getUsername(), cartRequest.getBreedVariety(), cartRequest.getBreedName());
//        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"success\"}");
//    }
@PostMapping("/remove")
public ResponseEntity<String> removeFromCart(@RequestBody CartRequest cartRequest) {
    try {
        logger.info("Received request to remove item from cart: {}", cartRequest);
        cartService.removeFromCart(cartRequest.getUsername(), cartRequest.getBreedVariety(), cartRequest.getBreedName());
        logger.info("Item removed from cart successfully");
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"success\"}");
    } catch (Exception e) {
        logger.error("Failed to remove item from cart", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\": \"error\"}");
    }
}

}
