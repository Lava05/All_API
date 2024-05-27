package com.customer.Ecommerrce.service.impl;

import com.customer.Ecommerrce.entity.UserCart;
import com.customer.Ecommerrce.repository.CartRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    @Autowired
    private CartRepository cartRepository;

    public void addToCart(String username, String breedVariety, String breedName) {
        UserCart cartItem = new UserCart(username, breedVariety, breedName);
        cartRepository.save(cartItem);
    }

    @Transactional
//    public void removeFromCart(String username, String breedVariety, String breedName) {
//        cartRepository.deleteByUsernameAndBreedNameAndBreedVariety(username, breedVariety, breedName);
//    }

    public void removeFromCart(String username, String breedVariety, String breedName) {
        try {
            logger.info("Removing item from cart: username={}, breedVariety={}, breedName={}", username, breedVariety, breedName);
            cartRepository.deleteByUsernameAndBreedNameAndBreedVariety(username, breedVariety, breedName);
            logger.info("Item removed from cart successfully");
        } catch (Exception e) {
            logger.error("Failed to remove item from cart", e);
            throw e;
        }
    }
}
