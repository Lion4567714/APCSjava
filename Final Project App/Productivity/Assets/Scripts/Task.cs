using System;using UnityEngine;

public class Task {
    
    public string name;
    public string desc;
    public int time;
    public int day;
    public int month;
    public int year;
    public int priority;

    public Task(string name, string desc, int time, int day, int month, int year, int priority)
    {
        this.name = name;
        this.desc = desc;
        this.time = time;
        this.day = day;
        this.month = month;
        this.year = year;
        this.priority = priority;
    }

    public override string ToString()
    {
        return this.name + "\t" + this.desc + "\t" + this.time + "\t" + this.day + "\t" + this.month + "\t" + this.year 
               + "\t" + this.priority;
    }
}

public enum Month
{
    January,
    February,
    March,
    April,
    May,
    June,
    July,
    August,
    September,
    October,
    November,
    December
}