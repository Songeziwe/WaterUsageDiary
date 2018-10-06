package com.example.andriod.waterusagediary;

/* This class acts as a model for items diary entries that will be listed on the overview window
 *
 * Author: Songeziwe S. Soboois
 * Date: 12/09/2018
 */

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
