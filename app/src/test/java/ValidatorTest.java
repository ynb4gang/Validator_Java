import org.junit.jupiter.api.Test;
import schemas.MapSchema;
import schemas.NumberSchema;
import schemas.StringSchema;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    void testStringSchemaValidation() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));

        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));

        assertTrue(schema.contains("wh").isValid("what does the fox say"));
        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));

        assertFalse(schema.isValid("what does the fox say"));
    }
}

class NumberSchemaTest {
    @Test
    void testNumberSchemaValidation() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertTrue(schema.isValid(null)); // null валиден, так как не вызывался required
        assertTrue(schema.isValid(5)); // без ограничений, валидное число

        schema.required();

        assertFalse(schema.isValid(null)); // null не валиден из-за required
        assertTrue(schema.isValid(10)); // валидное число

        schema.positive();

        assertFalse(schema.isValid(-10)); // не положительное число
        assertFalse(schema.isValid(0)); // не положительное число
        assertTrue(schema.isValid(5)); // положительное число

        schema.range(5, 10);

        assertTrue(schema.isValid(5)); // в диапазоне
        assertTrue(schema.isValid(10)); // в диапазоне
        assertFalse(schema.isValid(4)); // ниже диапазона
        assertFalse(schema.isValid(11)); // выше диапазона
    }
}
class MapSchemaTest {
    @Test
    void testMapSchemaValidation() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        assertTrue(schema.isValid(null)); // null валиден, так как не вызывался required

        schema.required();

        assertFalse(schema.isValid(null)); // null не валиден из-за required
        assertTrue(schema.isValid(new HashMap<>())); // пустая Map валидна

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data)); // непустая Map валидна

        schema.sizeof(2);

        assertFalse(schema.isValid(data)); // размер Map не соответствует ожидаемому
        data.put("key2", "value2");
        assertTrue(schema.isValid(data)); // размер Map соответствует ожидаемому
    }
}