package com.demoBlaze.platform;

import com.demoBlaze.pages.*;

public class DemoBlaze {
    public Home home;
    public Signup signup;
    public Login login;
    public Product product;
    public Cart cart;
    public PlaceOrder placeOrder;

    public DemoBlaze(){
        home = new Home();
        signup = new Signup();
        login = new Login();
        product = new Product();
        cart = new Cart();
        placeOrder = new PlaceOrder();
    }

}
