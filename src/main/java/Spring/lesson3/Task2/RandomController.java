package Spring.lesson3.Task2;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import Spring.lesson3.Task2.Entity.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class RandomController {

    // Mapping: /uuid
    @GetMapping("/uuid")
    @ResponseBody
    public String getRandomUUID() {
        UUID uuid = UUID.randomUUID();
        return "{\"uuid\":\"" + uuid.toString() + "\"}";
    }

    // Mapping: /exchange
    @GetMapping("/exchange")
    @ResponseBody
    public String getRandomExchangeRate() {
        // generate random exchange rate between 0.5 and 2.0
        double rate = Math.random() * (2.0 - 0.5) + 0.5;
        return "{\"exchange_rate\":" + rate + "}";
    }

    // Mapping: /exchange/{currency}
    @GetMapping("/exchange/{currency}")
    @ResponseBody
    public String getRandomExchangeRate(@PathVariable String currency) throws JsonProcessingException {
        // generate random exchange rate for given currency
        double rate = Math.random() * (2.0 - 0.5) + 0.5;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Root[] root = objectMapper.readValue(new File("C:\\Users\\Вова\\IdeaProjects\\Java_ITVDN\\JavaSpring\\src\\main\\resources\\currency.json"), Root[].class);

            if (currency.equalsIgnoreCase("USD")){
                return "{currency: " + currency + ", exchange_rate: " + root[1].getBuy()+ "}";
            } else if (currency.equalsIgnoreCase("EUR")) {
                return "{currency: " + currency + ", exchange_rate: " + root[0].getBuy()+ "}";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "{currency: " + currency + ", exchange_rate: " + rate + "}";
    }
}
