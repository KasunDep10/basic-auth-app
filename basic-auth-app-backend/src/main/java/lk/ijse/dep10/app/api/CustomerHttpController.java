package lk.ijse.dep10.app.api;

import lk.ijse.dep10.app.dto.CustomerDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customers")
public class CustomerHttpController {

    private final JdbcTemplate jdbcTemplate;

    public CustomerHttpController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final RowMapper<CustomerDTO> CUSTOMER_DTO_ROW_MAPPER = (rs, rowNum)->{
        return new CustomerDTO(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("address"));
    };

    @GetMapping
    public List<CustomerDTO> getAllCustomers(){
        return jdbcTemplate.query("SELECT * FROM customer", CUSTOMER_DTO_ROW_MAPPER);
    }

}
