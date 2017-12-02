package com.example.binyamin.android5778_0445_7734_01.model.entities;

/**
 * Created by binyamin on 09/11/2017.
 */

public class Branch {

    static long uniqueId = 4001 ;
    String branchCity;
    String branchStreet;
    int branchStreetNumber;
    int branchAmountParkingPLace;
    long branchId;

    public String getBranchCity() {
        return branchCity;
    }

    public void setBranchCity(String branchCity) {
        this.branchCity = branchCity;
    }

    public String getBranchStreet() {
        return branchStreet;
    }

    public void setBranchStreet(String branchStreet) {
        this.branchStreet = branchStreet;
    }

    public int getBranchStreetNumber() {
        return branchStreetNumber;
    }

    public void setBranchStreetNumber(int branchStreetNumber) {
        this.branchStreetNumber = branchStreetNumber;
    }

    public int getBranchAmountParkingPLace() {
        return branchAmountParkingPLace;
    }

    public void setBranchAmountParkingPLace(int branchAmountParkingPLace) {
        this.branchAmountParkingPLace = branchAmountParkingPLace;
    }

    public  long getBranchId() {
        return branchId;
    }

    public  void setBranchId(long branchId) {

        if(branchId >0)
            this.branchId = branchId;

        else
        {
            this.branchId = uniqueId;
            uniqueId++;
        }

    }
}
