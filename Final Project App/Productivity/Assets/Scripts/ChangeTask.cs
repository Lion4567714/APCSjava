using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ChangeTask : MonoBehaviour
{
    public TaskController taskCon;
    
    private void Start()
    {
        taskCon = GameObject.Find("Main Menu").GetComponent<TaskController>();
    }

    public void EditTaskFunction()
    {
        GameObject menu = GameObject.Find("NewTaskMenu");
        menu.SetActive(true);
        
    }
    
    public void DeleteTaskFunction()
    {
        taskCon.tasks.Remove(this.GetComponent<TaskDisplay>().task);
        taskCon.DisplayCurrentTasks();
    }
}
