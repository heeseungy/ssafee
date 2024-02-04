package coffee.ssafy.ssafee.domain.shop.controller;

import coffee.ssafy.ssafee.domain.manager.service.ManagerService;
import coffee.ssafy.ssafee.domain.shop.dto.request.ShopRequest;
import coffee.ssafy.ssafee.domain.shop.dto.response.ShopDetailResponse;
import coffee.ssafy.ssafee.domain.shop.dto.response.ShopResponse;
import coffee.ssafy.ssafee.domain.shop.service.ShopService;
import coffee.ssafy.ssafee.jwt.dto.JwtPrincipalInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shops")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;
    private final ManagerService managerService;

    @GetMapping
    @Operation(summary = "가게 목록 조회")
    public ResponseEntity<List<ShopResponse>> getShops() {
        return ResponseEntity.ok().body(shopService.findShops());
    }

    @GetMapping("/{id}")
    @Operation(summary = "가게 조회")
    public ResponseEntity<ShopDetailResponse> getShop(@PathVariable Long id) {
        return ResponseEntity.ok().body(shopService.findShopById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "가게 수정", security = @SecurityRequirement(name = "access-token"))
    public ResponseEntity<Void> updateShop(@AuthenticationPrincipal JwtPrincipalInfo principal,
                                           @PathVariable Long id,
                                           @RequestBody ShopRequest shopRequest) {
        managerService.validate(principal, id);
        shopService.updateShop(id, shopRequest);
        return ResponseEntity.noContent().build();
    }

}
