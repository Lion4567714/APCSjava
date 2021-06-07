using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class TaskSorter : MonoBehaviour
{
    public TaskController taskCon;
    public Text sortingText;
    private int sortingMethod;

    private void Start()
    {
        sortByTime();
    }

    public void cycleSorting()
    {
        sortingMethod++;
        if (sortingMethod > 2)
        {
            sortingMethod = 0;
        }

        switch (sortingMethod)
        {
            case 0:
                sortByTime();
                break;
            case 1:
                sortByPriority();
                break;
            case 2:
                sortAlphabetically();
                break;
        }
        
        taskCon.DisplayCurrentTasks();
    }

    private void sortByTime()
    {
        sortingText.text = "Time";
        
        List<Task> tasks = taskCon.tasks;

        for (int i = 0; i < tasks.Count; i++)
        {
            Task firstTask = tasks[i];
            int index = i;

            for (int j = i; j < tasks.Count; j++)
            {
                if (tasks[j].time < firstTask.time)
                {
                    firstTask = tasks[j];
                    index = j;
                }
            }

            tasks[index] = tasks[i];
            tasks[i] = firstTask;
        }

        taskCon.tasks = tasks;
    }

    private void sortByPriority()
    {
        sortingText.text = "Priority";
        
        List<Task> tasks = taskCon.tasks;

        for (int i = 0; i < tasks.Count; i++)
        {
            Task importantTask = tasks[i];
            int index = i;

            for (int j = i; j < tasks.Count; j++)
            {
                if (tasks[j].priority > importantTask.priority)
                {
                    importantTask = tasks[j];
                    index = j;
                }
            }
            
            tasks[index] = tasks[i];
            tasks[i] = importantTask;
        }

        taskCon.tasks = tasks;
    }

    private void sortAlphabetically()
    {
        sortingText.text = "Alphabetical";
        
        List<Task> tasks = taskCon.tasks;

        for (int i = 0; i < tasks.Count; i++)
        {
            Task firstTask = tasks[i];
            string name1 = firstTask.name.ToLower();
            int index = i;
            
            for (int j = i; j < tasks.Count; j++)
            {
                string name2 = tasks[j].name.ToLower();
                int shortLen = name1.Length;
                if (name2.Length < shortLen)
                {
                    shortLen = name2.Length;
                }

                for (int k = 0; k < shortLen; k++)
                {
                    if (name2[k] < name1[k])
                    {
                        firstTask = tasks[j];
                        name1 = firstTask.name.ToLower();
                        index = j;
                        break;
                    }
                }
            }

            tasks[index] = tasks[i];
            tasks[i] = firstTask;
        }

        taskCon.tasks = tasks;
    }
}
