package managesystem;

public class CantFindGoodsException extends Exception{
 public CantFindGoodsException() {
  
 }
 
 public CantFindGoodsException(String name) {
  super(name);
 }
}