import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldFindById() {
        Product product1 = new Product(5, "Макароны", 22);
        Product product2 = new Product(8, "Яйца", 67);

        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);

        Product expected = product1;
        Product actual = repo.findById(5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        Product product1 = new Product(5, "Макароны", 22);
        Product product2 = new Product(8, "Яйца", 67);

        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);

        Product[] expected = {product2};
        Product[] actual = repo.removeById(5);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowAnException() {
        Product product1 = new Product(5, "Макароны", 22);
        Product product2 = new Product(8, "Яйца", 67);

        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });
    }
}
