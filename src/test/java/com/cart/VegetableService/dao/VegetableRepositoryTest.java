package com.cart.VegetableService.dao;
import com.cart.VegetableService.entity.Vegetable;
import com.cart.VegetableService.entity.VegetableCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VegetableRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VegetableRepository vegetableRepository;

    @Test
    public void saveAndFlushTest(){
        Vegetable vegetable = new Vegetable();
        vegetable.setName("Tomato");
        vegetable.setCategory(VegetableCategory.fruit);
        vegetable = vegetableRepository.saveAndFlush(vegetable);
        assertNotNull(vegetableRepository.findById(vegetable.getId()));
    }

    @Test
    public void findByIdTest(){
        Vegetable vegetable = new Vegetable();
        vegetable.setName("Tomato");
        vegetable.setCategory(VegetableCategory.fruit);
        vegetable = entityManager.persistAndFlush(vegetable);
        Optional<Vegetable> vegetable1 = vegetableRepository.findById(vegetable.getId());
        assertTrue(vegetable1.isPresent());
        assertEquals(vegetable.getName(),vegetable1.get().getName());
        assertNotNull(vegetable1.get().getAvailableQuantity());
    }
}
