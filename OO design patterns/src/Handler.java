
// separates the sender of a request from its receivers by giving multiple objects
// a chance to handle the request
interface Handler {
    void setNext(Handler handler); // Declaring an abstract method named setNext
    // which takes a Handler object as a parameter
    void handle(String operation); // Declaring an abstract method which takes a
    // String named operation as a parameter

class CartHandler implements Handler {
    private Handler next;//Declaring a private instance variable named next of type
    // Handler
    @Override
    public void setNext(Handler handler) {
        this.next = handler; // Assigning the Handler object passed into the method
        // to the next instance variable of the CartHandler object
    }
    @Override
    public void handle(String operation) {
        if (operation.equals("ADD_TO_CART")) {
            System.out.println("Item added to the cart.");
        } else if (next != null) { // checking if there is a next handler in the
            // chain
            next.handle(operation);
        }
    }
}
class DiscountHandler implements Handler {
    private Handler next;
    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }
    @Override
    public void handle(String operation) {
        if (operation.equals("APPLY_DISCOUNT")) {
            System.out.println("Discount applied to the cart.");
        } else if (next != null) {
            next.handle(operation);
        }
    }
}
class PaymentHandler implements Handler {
    private Handler next;
    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }
    @Override
    public void handle(String operation) {
        if (operation.equals("MAKE_PAYMENT")) {
            System.out.println("Payment made for the items in the cart.");
        } else if (next != null) {
            next.handle(operation);
        }
    }
}

class DemoHandler {
    public static void main(String[] args) {
        Handler cartHandler = new CartHandler();
        Handler discountHandler = new DiscountHandler();
        Handler paymentHandler = new PaymentHandler();

        cartHandler.setNext(discountHandler);
        discountHandler.setNext(paymentHandler); // Form the chain
        // (cartHandler -> discountHandler -> paymentHandler)

        cartHandler.handle("ADD_TO_CART");
        cartHandler.handle("APPLY_DISCOUNT");
        cartHandler.handle("MAKE_PAYMENT");
        }
    }
}

