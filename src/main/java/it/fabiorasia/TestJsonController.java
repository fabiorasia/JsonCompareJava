package it.fabiorasia;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestJsonController {

    @PostMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public Map create(@RequestBody Map input) {
        Map<String, Object> result = new HashMap<>();
        result.put("Integer",
                (Integer) input.get("int1")
                + (Integer) input.get("int10")
                + (Integer) ((Map) input.get("subObject")).get("int5")
                + (Integer) ((Map) input.get("subObject")).get("int15")
        );
        result.put("String",
                (String) input.get("string1")
                + (String) input.get("string10")
                + (String) ((Map) input.get("subObject")).get("string5")
                + (String) ((Map) input.get("subObject")).get("string15")
        );
        result.put("Boolean",
                (Boolean) input.get("boolean1")
                && (Boolean) input.get("boolean10")
                && (Boolean) ((Map) input.get("subObject")).get("boolean5")
                && (Boolean) ((Map) input.get("subObject")).get("boolean15")
        );
        return result;
    }
}
