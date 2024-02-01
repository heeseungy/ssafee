package coffee.ssafy.ssafee.domain.shop.service;

import coffee.ssafy.ssafee.domain.shop.dto.request.MenuCategoryRequest;
import coffee.ssafy.ssafee.domain.shop.entity.MenuCategory;
import coffee.ssafy.ssafee.domain.shop.entity.Shop;
import coffee.ssafy.ssafee.domain.shop.mapper.MenuCategoryMapper;
import coffee.ssafy.ssafee.domain.shop.repository.MenuCategoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuCategoryService {

    @PersistenceContext
    private final EntityManager entityManager;
    private final MenuCategoryRepository menuCategoryRepository;
    private final MenuCategoryMapper menuCategoryMapper;

    @Transactional
    public List<String> findMenuCategories(Long shopId) {
        return menuCategoryRepository.findAllByShopId(shopId).stream()
                .map(MenuCategory::getName)
                .toList();
    }

    @Transactional
    public Long createMenuCategories(Long shopId, MenuCategoryRequest menuCategoryRequest) {
        MenuCategory menuCategory = menuCategoryMapper.toEntity(menuCategoryRequest);
        menuCategory.setShop(entityManager.getReference(Shop.class, shopId));
        menuCategoryRepository.save(menuCategory);
        return menuCategory.getId();
    }

    @Transactional
    public void updateMenuCategory(Long menuCategoryId, MenuCategoryRequest menuCategoryRequest) {
        menuCategoryRepository.findById(menuCategoryId).ifPresent(menuCategory -> {
            menuCategoryMapper.updateMenuCategory(menuCategory, menuCategoryRequest);
            menuCategoryRepository.save(menuCategory);
        });
    }

    @Transactional
    public void deleteMenuCategory(Long menuCategoryId) {
        menuCategoryRepository.deleteById(menuCategoryId);
    }

}