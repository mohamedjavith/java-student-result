package ajaxprojectdbconnection;

public class mobile {
   String brand;
   int price;
   String ram;
 
public mobile(String brand, int price, String ram) {
	super();
	this.brand = brand;
	this.price = price;
	this.ram = ram;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}

public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getRam() {
	return ram;
}

public void setRam(String ram) {
	this.ram = ram;
}
@Override
public String toString() {
	return "mobile [brand=" + brand + ", price=" + price + ", ram=" + ram + "]";
}
}
