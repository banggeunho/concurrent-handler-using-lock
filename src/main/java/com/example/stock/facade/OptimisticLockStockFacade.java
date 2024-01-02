package com.example.stock.facade;

import org.springframework.stereotype.Service;

import com.example.stock.service.StockWithOptimisticLockService;

@Service
public class OptimisticLockStockFacade {

    private StockWithOptimisticLockService stockWithOptimisticLockService;

    public OptimisticLockStockFacade(StockWithOptimisticLockService stockWithOptimisticLockService) {
        this.stockWithOptimisticLockService = stockWithOptimisticLockService;
    }

    public void decrease(Long id, Long quantity) throws InterruptedException {
        while (true) {
            try {
                stockWithOptimisticLockService.decrease(id, quantity);

                break;
            } catch (Exception exception) {
                Thread.sleep(50);
            }
        }
    }
    
}
