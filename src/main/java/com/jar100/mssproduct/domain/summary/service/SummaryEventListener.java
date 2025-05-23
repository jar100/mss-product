package com.jar100.mssproduct.domain.summary.service;

import com.jar100.mssproduct.common.dto.ProductChangedEvent;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SummaryEventListener {
    //private final SummaryService summaryService;

    @Async              // 비동기 처리
    @Transactional      // 트랜잭션 안에서 DB 반영
    @EventListener
    public void onProductChanged(ProductChangedEvent ev) {
        //// 1) 브랜드×카테고리별 최소가 요약 갱신
        //summaryService.updateBrandCategoryMin(
        //    ev
        //);
        //
        //// 2) 카테고리별 최소/최고가 요약 갱신
        //summaryService.updateCategorySummary(ev);
        //
        //// 3) 브랜드별 총액 최저 요약 갱신
        //summaryService.updateBrandTotal(ev);
    }

}
