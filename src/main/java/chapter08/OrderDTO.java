package chapter08;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
public class OrderDTO implements Serializable {

    private Long orderId;
    private Date creationDate;
    private String customerName;
    private Float totalAmount;

}
