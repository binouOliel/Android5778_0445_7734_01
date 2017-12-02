package com.example.binyamin.android5778_0445_7734_01.model.entities;

/**
 * Created by binyamin on 10/11/2017.
 */

public class Car {
    static long uniqueId = 3001 ;

    long branchIdCarParked;
    long typeModelID;
    int kilometre;
    long carId;

    public long getBranchIdCarParked() {
        return branchIdCarParked;
    }

    public void setBranchIdCarParked(long branchIdCarParked) {
        this.branchIdCarParked = branchIdCarParked;
    }

    public long getTypeModelID() {
        return typeModelID;
    }

    public void setTypeModelID(long typeModelID) {
        this.typeModelID = typeModelID;
    }

    public int getKilometre() {
        return kilometre;
    }

    public void setKilometre(int kilometre) {
        this.kilometre = kilometre;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {

        if(carId > 0)
            this.carId = carId;
        else
        {
            this.carId = uniqueId;
            uniqueId++;
        }
    }
}
