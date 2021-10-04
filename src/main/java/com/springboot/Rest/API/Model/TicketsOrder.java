package com.springboot.Rest.API.Model;

public class TicketsOrder {
    private int numOfChildren;
    private int numOfAdults;
    public int totalTickets;

    public final int childTicketPrice = 7;
    public final int adultTicketPrice = 12;

    public TicketsOrder(int numOfAdults, int numOfChildren) {
        this.numOfAdults = numOfAdults;
        this.numOfChildren = numOfChildren;
        this.totalTickets = this.getAdultTicketCount() + this.getChildTicketCount();
    }

    /**
     * @return the num of child tickets
     */
    public int getChildTicketCount() {
        return numOfChildren;
    }

    /**
     * @return the num of adult tickets
     */
    public int getAdultTicketCount() {
        return numOfAdults;
    }
}
