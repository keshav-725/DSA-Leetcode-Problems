class ParkingSystem {
    HashMap<Integer,Integer> parkingSlot;
    
    public ParkingSystem(int big, int medium, int small) {
        parkingSlot = new HashMap<>();
        parkingSlot.put(1,big);
        parkingSlot.put(2,medium);
        parkingSlot.put(3,small);
    }
    
    public boolean addCar(int carType) {
        int availableSlot = parkingSlot.getOrDefault(carType,0);
        if(availableSlot==0) return false;
        else{
            parkingSlot.put(carType,parkingSlot.get(carType)-1);
            return true;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */