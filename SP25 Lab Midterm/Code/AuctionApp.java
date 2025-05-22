/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionapp;

/**
 *
 * @author sp23-bse-045
 */

interface Bidder {
    void notifyBid(String item, double price );
            
            }

 class Buyer implements Bidder {
     String name;
     
     public Buyer (String name){
         this.name=name;
     }
     
     public void notifyBid (String item, double price){
         System.out.println(name + ": New bid on" +item + " at Rs." + price);
     }
 }


class Auction {
    List<Bidder> bidders = new ArrayList<>();
    
    double highestBid=0;
    
    public void register (Bidder b)
    {bidders.add (b);}
    
    public void newBid(String item, double amount){
        if(amount > highestBid){
            highestBid=amount;
            for (Bidder b : bidders){
                b.notifyBid(item,amount);
            }
        }
    }

}


public class AuctionApp {
    
    
    

    public static void main(String[] args) {
        Auction auction = new Auction();
        auction.register(new Buyer("AHmed"));
        auction.register(new Buyer("Zahra"));
        
        auction.newBid("Car", 5500000);
    }
    
}