package pl.gutmat.creditcard;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/creditcard")

class CreditCardController{
    
    CreditCardApi api;
    
    
    @Autowired
    public CreditCardController(CreditCardApi api){
        this.api = api;
    }
    
    
    @GetMapping("/{number}")
    public String balance() {
       return "200 zł";
    } 
    
    
    @PostMapping("/{number}/{money}")
    public void withdraw(@PathVariable String number, @PathVariable double money) {
        try {
            api.withdraw(number, money);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
    
   /* @RequestMapping("/{number}")
    public String cardBalance(@PathVariable String number) {
        CardInfo info = new CardInfo();
        info.number = number;
        info.balance = 3000;
        return info;
    } */
  
    
  /*  class CardInfo {
        public String number;
    }
    
    */
    
    
    
}