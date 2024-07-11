package com.example.websalescrud.controller;

import com.example.websalescrud.model.WebSale;
import com.example.websalescrud.service.WebSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/websales")
public class WebSaleController {

    @Autowired
    private WebSaleService webSaleService;

    @GetMapping
    public List<WebSale> getAllWebSales() {
        return webSaleService.getAllWebSales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebSale> getWebSaleById(@PathVariable Long id) {
        return webSaleService.getWebSaleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public WebSale createWebSale(@RequestBody WebSale webSale) {
        return webSaleService.saveWebSale(webSale);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WebSale> updateWebSale(@PathVariable Long id, @RequestBody WebSale webSale) {
        return webSaleService.getWebSaleById(id)
                .map(existingWebSale -> {
                    webSale.setId(id);
                    return ResponseEntity.ok(webSaleService.saveWebSale(webSale));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWebSale(@PathVariable Long id) {
        return webSaleService.getWebSaleById(id)
                .map(webSale -> {
                    webSaleService.deleteWebSale(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
