
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    public void everyStatementTest() {
        // TC1
        List<Item> item1 = null;
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(item1, ""));

        // TC2
        List<Item> item2 = new ArrayList<>();
        item2.add(new Item("", 1, 100, 0));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(item2, ""));

        // TC3
        List<Item> item3 = new ArrayList<>();
        item3.add(new Item("A", 11, 400, 0.4));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(item3, null));

        // TC4
        List<Item> item4 = new ArrayList<>();
        item4.add(new Item("B", 11, 100, 0));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(item4, "1234abcd56789123"));

        // TC5
        List<Item> item5 = new ArrayList<>();
        item5.add(new Item("C",11,100,0));
        double result = SILab2.checkCart(item5, "1234567891234567");
        assertEquals(1070.0, result, 0.001);
    }

    @Test
    public void multipleConditionTest() {
        // TXX
        List<Item> item1 = new ArrayList<>();
        item1.add(new Item("A",5,400,0));
        double result1 = SILab2.checkCart(item1, "1234567891234567");
        assertEquals(1970.0, result1, 0.001);

        // FTX
        List<Item> item2 = new ArrayList<>();
        item2.add(new Item("B",5,250,0.5));
        double result2 = SILab2.checkCart(item2, "1234567891234567");
        assertEquals(595.0, result2, 0.001);

        // FFT
        List<Item> item3 = new ArrayList<>();
        item3.add(new Item("C",15,250,0));
        double result3 = SILab2.checkCart(item3, "1234567891234567");
        assertEquals(3720.0, result3, 0.001);

        // FFF
        List<Item> item4 = new ArrayList<>();
        item4.add(new Item("D",5,250,0));
        double result4 = SILab2.checkCart(item4, "1234567891234567");
        assertEquals(1250.0, result4, 0.001);
    }
}