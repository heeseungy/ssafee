package coffee.ssafy.ssafee.domain.shop.controller;

import coffee.ssafy.ssafee.domain.shop.dto.response.OptionResponse;
import coffee.ssafy.ssafee.domain.shop.service.OptionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shops/{shop_id}/option-categories/{oc_id}")
@RequiredArgsConstructor
public class OptionController {

    private final OptionService optionService;

    @GetMapping("/options")
    @Operation(summary = "옵션 조회")
    public ResponseEntity<List<OptionResponse>> getOptionsByCategory(
            @PathVariable("oc_id") Long optionCategoryId) {
        return ResponseEntity.ok().body(optionService.getOptionsByCategory(optionCategoryId));
    }


}