package com.jar100.mssproduct.domain.summary.service;

import com.jar100.mssproduct.common.dto.ProductChangedEvent;
import com.jar100.mssproduct.domain.summary.repository.PriceQueryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SummaryEventListener {
    private final SummaryService summaryService;

    @Async              // 비동기 처리
    @Transactional      // 트랜잭션 안에서 DB 반영
    @EventListener
    public void onProductChanged(ProductChangedEvent ev) {
        log.info("Product changed event received: {}", ev);
        // 1) 브랜드×카테고리 최소가 요약 갱신
        boolean brandCatMinChanged = summaryService.updateBrandCategoryMin(ev);

        // 2) 카테고리 요약 갱신
        summaryService.updateCategorySummary(ev);

        // 3) 브랜드별 총액 최저가 요약은 위 둘 중 하나라도 바뀌었을 때만
        if (brandCatMinChanged) {
            summaryService.updateBrandTotal(ev);
        }
    }

}
