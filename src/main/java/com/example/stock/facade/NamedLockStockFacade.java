package com.example.stock.facade;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.stock.repository.NamedLockRepository;
import com.example.stock.service.StockService;


@Service
public class NamedLockStockFacade {

    private NamedLockRepository namedLockRepository;

    private StockService stockService;

    public NamedLockStockFacade(NamedLockRepository namedLockRepository, StockService stockService) {
        this.namedLockRepository = namedLockRepository;
        this.stockService = stockService;
    }

    @Transactional
    public void decrease(Long id, Long quantity) {
        try {
            namedLockRepository.getLock(id.toString());
            stockService.decrease(id, quantity);
        } finally {
            namedLockRepository.releaseLock(id.toString());
        }
    }
    
}
