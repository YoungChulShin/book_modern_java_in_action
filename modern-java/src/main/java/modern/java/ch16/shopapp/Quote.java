package modern.java.ch16.shopapp;

import modern.java.ch16.shopapp.Discount.Code;

public class Quote {

  private final String shopName;
  private final double price;
  private final Discount.Code discountCode;

  public Quote(String shopName, double price, Code discountCode) {
    this.shopName = shopName;
    this.price = price;
    this.discountCode = discountCode;
  }

  public static Quote parse(String s) {
    String[] split = s.split(":");
    return new Quote(split[0], Double.parseDouble(split[1]), Discount.Code.valueOf(split[2]));
  }

  public String getShopName() {
    return shopName;
  }

  public double getPrice() {
    return price;
  }

  public Code getDiscountCode() {
    return discountCode;
  }
}
