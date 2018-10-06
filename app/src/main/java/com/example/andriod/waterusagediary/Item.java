package com.example.andriod.waterusagediary;

public class Item {
    private String date;
    private String amount;

    public Item()
    {
        date = "none";
        amount = "0 L";
    }
    public Item(String date, String amount)
    {
        this.date = date;
        this.amount = amount;
    }
    public String getDate(){ return date; }
    public String getAmount() { return amount; }

    public void setDate(String date){ this.date = date; }
    public void setAmount(String amount){ this.amount = amount; }
}
