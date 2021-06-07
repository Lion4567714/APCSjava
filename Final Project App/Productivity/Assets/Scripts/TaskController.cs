using System;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using UnityEngine;
using System.IO;

public class TaskController : MonoBehaviour
{
    public string path = "Assets/Resources/savedTasks.txt";
    public List<Task> tasks = new List<Task>();
    public GameObject taskPrefab;
    
    private List<GameObject> taskGOs = new List<GameObject>();

    void Start()
    {
        var reader = new StreamReader(path);

        string line;
        while ((line = reader.ReadLine()) != null)
        {
            string[] arr = line.Split('\t');
            tasks.Add(new Task(arr[0], arr[1], int.Parse(arr[2]), int.Parse(arr[3]),
                int.Parse(arr[4]), int.Parse(arr[5]), int.Parse(arr[6])));
        }
        
        reader.Close();
        DisplayCurrentTasks();
    }

    private void ClearCurrentTasks()
    {
        foreach (GameObject clone in taskGOs)
        {
            Destroy(clone);
        }
    }
    
    public void DisplayCurrentTasks()
    {
        ClearCurrentTasks();
        
        int i = 0;
        foreach (Task t in tasks)
        {
            if (t.day == System.DateTime.Today.Day)
            {
                var taskClone = Instantiate(taskPrefab, this.transform);
                taskClone.transform.Translate(0, -110 * i, 0);
                taskClone.GetComponent<TaskDisplay>().task = t;

                taskGOs.Add(taskClone);
                i++;
            }
        }
    }

    void OnApplicationQuit()
    {
        var writer = new StreamWriter(path, false);

        foreach (Task t in tasks)
        {
            writer.WriteLine(t.ToString());
        }
        
        writer.Close();
    }
}
