package com.example.websalescrud.service;

import com.example.websalescrud.model.WebSale;
import com.example.websalescrud.repository.WebSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebSaleService {

    @Autowired
    private WebSaleRepository webSaleRepository;

    public List<WebSale> getAllWebSales() {
        return webSaleRepository.findAll();
    }

    public Optional<WebSale> getWebSaleById(Long id) {
        return webSaleRepository.findById(id);
    }

    public WebSale saveWebSale(WebSale webSale) {
        return webSaleRepository.save(webSale);
    }

    public void deleteWebSale(Long id) {
        webSaleRepository.deleteById(id);
    }
}
