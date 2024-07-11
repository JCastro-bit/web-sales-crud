package com.example.websalescrud.repository;

import com.example.websalescrud.model.WebSale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSaleRepository extends JpaRepository<WebSale, Long> {
}
