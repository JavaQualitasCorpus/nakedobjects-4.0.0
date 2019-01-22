package org.nakedobjects.examples.orders.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.nakedobjects.applib.AbstractFactoryAndRepository;
import org.nakedobjects.applib.annotation.Named;
import org.nakedobjects.examples.orders.domain.Customer;
import org.nakedobjects.examples.orders.domain.Order;


@Named("Orders")
public class OrderRepository extends AbstractFactoryAndRepository {

    // use ctrl+space to bring up the NO templates.
    
    // also, use CoffeeBytes code folding with
    // user-defined regions of {{ and }}

    
    // {{ findRecentOrders
    public List<Order> findRecentOrders(Customer customer, @Named("Number of Orders") Integer numberOfOrders) {
        List<Order> orders = customer.getOrders();
        Collections.sort(orders, new Comparator<Order>() {
            public int compare(Order o1, Order o2) {
                long time1 = o1.getOrderDate().getTime();
                long time2 = o2.getOrderDate().getTime();
                return (int) (time2 - time1);
            }
        });
        if (orders.size() < numberOfOrders) {
            return orders;
        } else {
            return orders.subList(0, numberOfOrders);
        }
    }
  public Object[] defaultFindRecentOrders(Customer customer, Integer numberOfOrders) {
        return new Object[] { null, new Integer(3) };
    }

    // }}

    // {{ identification
    /**
     * Use <tt>Order.gif</tt> for icon.
     */
    public String iconName() {
        return "Order";
    }
    // }}
    
    

}
