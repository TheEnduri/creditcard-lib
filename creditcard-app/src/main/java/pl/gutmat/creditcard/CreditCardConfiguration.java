package pl.gutmat.creditcard;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;


@Configuration
class CreditCardConfiguration {
    
    @Bean
    public CreditCardApi creditCardApi() {
        CreditCardPool pool = new CreditCardPool();
        CreditCard c1 = new CreditCard("1234");
        CreditCard c2 = new CreditCard("5678");
        
        pool.add(c1);
        pool.add(c2);
        
        return new CreditCardApi(pool);
    }
}