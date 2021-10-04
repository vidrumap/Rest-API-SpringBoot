package com.springboot.Rest.API.Controller;

import com.springboot.Rest.API.Model.Receipt;
import com.springboot.Rest.API.Model.TicketsOrder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {

    // discount is applied when total number of tickets is 3 or more
    private final int minTicketsForDiscount = 3;
    private final double discount = 0.15;

    private Receipt calculateBill(TicketsOrder order) {
        double totalBill = (order.getChildTicketCount() * order.childTicketPrice) + (order.getAdultTicketCount() * order.adultTicketPrice);

        if(order.totalTickets >= minTicketsForDiscount) {
            totalBill -= totalBill * discount;
        }

        return new Receipt(totalBill);
    }

    @PostMapping(path = "/buyTickets")
    public @ResponseBody Receipt calculateOrderTotal(@RequestBody TicketsOrder order) {
        return calculateBill(order);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ex.getMessage();
    }
}
