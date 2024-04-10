package lk.ijse.supermarket.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data   // getter setter and tostring
public class Item {
    private String code;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
}
