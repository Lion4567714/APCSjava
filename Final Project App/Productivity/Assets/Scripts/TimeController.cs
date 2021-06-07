using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class TimeController : MonoBehaviour
{
    public Dropdown hourDropdown;
    public Dropdown minuteDropdown;
    public Dropdown timeOfDayDropdown;
    public Dropdown monthDropdown;
    public Dropdown dayDropdown;
    
    void Start()
    {
        hourDropdown.value = System.DateTime.Now.Hour % 12 - 1;

        minuteDropdown.value = System.DateTime.Now.Minute / 5;

        timeOfDayDropdown.value = System.DateTime.Now.Hour / 12;

        monthDropdown.value = System.DateTime.Now.Month - 1;

        dayDropdown.value = System.DateTime.Now.Day - 1;
    }

    public void addDays(int month)
    {
        dayDropdown.ClearOptions();

        List<string> options = new List<string>();
        int days = System.DateTime.DaysInMonth(System.DateTime.Now.Year, month + 1);
        
        for (int i = 1; i <= days; i++)
        {
            options.Add(i.ToString());
        }
        
        dayDropdown.AddOptions(options);
    }
}
