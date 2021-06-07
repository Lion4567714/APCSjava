using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class WeekViewController : MonoBehaviour
{
    public Text[] dayTextArr;
    public GameObject[] dayObjs;
    public GameObject weekTaskPrefab;
    public TaskController taskCon;

    private bool[,] display = new bool[3, 7];
    private List<GameObject> cloneGOs = new List<GameObject>();
    
    void Start()
    {
        int dayOfWeek = (int) System.DateTime.Now.DayOfWeek + 1;
        for (int i = 0; i < 3; i++)
        {
            if (dayOfWeek > 6)
            {
                dayOfWeek = 0;
            }

            dayTextArr[i].text = ((Week)dayOfWeek).ToString();
            dayOfWeek++;
        }

        displayTasks();
    }

    public void displayTasks()
    {
        foreach (GameObject g in cloneGOs)
        {
            Destroy(g);
        }
        display = new bool[3, 7];
        
        foreach (Task t in taskCon.tasks)
        {
            int place = -1;
            int diff = t.day - System.DateTime.Today.Day;

            GameObject parent = null;
            switch (diff)
            {
                case 1:
                    place = 0;
                    parent = dayObjs[0];
                    break;
                case 2:
                    place = 1;
                    parent = dayObjs[1];
                    break;
                case 3:
                    place = 2;
                    parent = dayObjs[2];
                    break;
            }

            if (parent != null)
            {
                for (int i = 0; i < 7; i++)
                {
                    if (!display[place, i])
                    {
                        display[place, i] = true;
                        GameObject taskClone = Instantiate(weekTaskPrefab, parent.transform);
                        taskClone.transform.Translate(0, -50 * i, 0);
                        taskClone.GetComponentInChildren<Text>().text = t.name;

                        cloneGOs.Add(taskClone);
                        break;
                    }
                }
            }
        }
    }
}

enum Week
{
    Sunday,
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday
}