package com.cursoJava.challenge1.service;


import com.cursoJava.challenge1.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order){
        double totalDiscount = order.getBasic() - (order.getBasic() * order.getDiscount()/100);
        return  totalDiscount + shippingService.shipment(order);
    }
}

//OBS: No componente que depende (OrderService), não usar o construtor padrão, pois pode dar erro
// e o spring não conseguir identificar o componente dependente (ShippingService). Há duas opções:
// Dentro do componente que depende, Usar a annotation @Autowired no componente dependente e NAO usar construtor nenhum.
// Ou não usar a annotation e usar somente o construtor com o argumento do qual depende.
