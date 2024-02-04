package coffee.ssafy.ssafee.domain.shop.mapper;

import coffee.ssafy.ssafee.domain.shop.dto.request.ShopRequest;
import coffee.ssafy.ssafee.domain.shop.dto.response.OptionCategoryDetailResponse;
import coffee.ssafy.ssafee.domain.shop.dto.response.ShopDetailResponse;
import coffee.ssafy.ssafee.domain.shop.dto.response.ShopResponse;
import coffee.ssafy.ssafee.domain.shop.entity.OptionCategory;
import coffee.ssafy.ssafee.domain.shop.entity.Shop;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ShopMapper {

    ShopDetailResponse toDetailDto(Shop shop);

    OptionCategoryDetailResponse toDetailDto(OptionCategory optionCategory);

    ShopResponse toDto(Shop shop);

}
