using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class AddTask : MonoBehaviour
{
    public TaskController taskControl;
    public Text nameText;
    public Text descText;
    public Dropdown hourDrop;
    public Dropdown minDrop;
    public Dropdown todDrop;
    public Dropdown monthDrop;
    public Dropdown dayDrop;
    public Dropdown priorityDrop;

    public void addTaskFunction()
    {
        int time = (hourDrop.value * 100) + (minDrop.value * 5) + (todDrop.value * 1200);
        taskControl.tasks.Add(new Task(nameText.text, descText.text, time, dayDrop.value + 1, 
            monthDrop.value + 1, System.DateTime.Now.Year, priorityDrop.value + 1));

        nameText.text = "";
        descText.text = "";
    }
}
