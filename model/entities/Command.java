package com.example.binyamin.android5778_0445_7734_01.model.entities;

import java.util.Date;

public class Command {
    long commandId;
    long commandClientId;
    COMMAND_STATE stateCommand;
    long commandCarId;
    Date commandStartRentingDate;
    Date commandEndRentingDate;
    int  startNumberKilometre;
    int endNumberKilometre;
    FUEL_STATE fuel_state;
    int amountOfLiterFilled;
    float bill;


}
