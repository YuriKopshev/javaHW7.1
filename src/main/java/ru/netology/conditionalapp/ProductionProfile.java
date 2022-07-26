package ru.netology.conditionalapp;

public class ProductionProfile implements SystemProfile{
    @Override
    public String gerProfile() {
        return "Current profile is production";
    }
}
