package lk.ijse.dep10.app.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customers")
public class CustomerHttpController {


    @GetMapping
    public String getAllCustomers() {
        return "<h1>Woking</h1>";
    }

}
