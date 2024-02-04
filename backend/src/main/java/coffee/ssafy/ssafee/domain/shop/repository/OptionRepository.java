package coffee.ssafy.ssafee.domain.shop.repository;

import coffee.ssafy.ssafee.domain.shop.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {

    List<Option> findAllByShopIdAndOptionCategoryId(Long shopId, Long optionCategoryId);

    Optional<Option> findByShopIdAndId(Long shopId, Long Id);

    void deleteByShopIdAndId(Long shopId, Long id);

}
