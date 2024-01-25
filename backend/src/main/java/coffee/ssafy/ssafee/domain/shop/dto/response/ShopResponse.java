package coffee.ssafy.ssafee.domain.shop.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ShopResponse(
        Long id,
        String name,
        String address,
        String phone,
        String image,
        Boolean enabledAutoOrder
) {
}
