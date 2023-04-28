package ru.netology.product.exceptionTesting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void deletingAnExistingProductById() {
        Product product1 = new Product(1, "Картошка", 100);
        Product product2 = new Product(2, "Лапша", 200);
        Product product3 = new Product(3, "Гречка", 300);

        ShopRepository repository = new ShopRepository();
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.remove(1);

        Product[] expected = {product2, product3};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void passingTheTestNotFoundException() {
        Product product1 = new Product(1, "Картошка", 100);
        Product product2 = new Product(2, "Лапша", 200);
        Product product3 = new Product(3, "Гречка", 300);

        ShopRepository repository = new ShopRepository();
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.remove(4);
        });
    }
}
