public class Restaurant {
    public void orderMeal(int roomNumber, String item, double price, FrontDesk frontDesk) {
        System.out.println("Meal ordered: " + item + " for Room " + roomNumber + " ($" + price + ")");
        frontDesk.addRoomCharge(roomNumber, price);
        System.out.println("Charge applied to room " + roomNumber);
    }
}
