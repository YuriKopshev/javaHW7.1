package ru.netology.conditionalapp;

public class DevProfile implements SystemProfile {
    @Override
    public String gerProfile() {
        return "current profile is dev";
    }
}
