using System.Threading.Tasks;
using UnityEngine;
using UnityEngine.UI;

public class TaskDisplay : MonoBehaviour
{
    public Task task;

    public Text nameText;
    public Text timeText;
    public Text dateText;

    void Start()
    {
        nameText.text = task.priority.ToString() + " | " + task.name;

        int time = task.time;
        bool isAM = true;
        if (task.time > 1300)
        {
            time -= 1200;
            isAM = false;
        } else if (task.time > 1200)
        {
            isAM = false;
        }
        
        timeText.text = (time / 100).ToString() + ":" + (time % 100).ToString().PadLeft(2, '0');
        if (isAM)
        {
            timeText.text += " AM";
        }
        else
        {
            timeText.text += " PM";
        }

        dateText.text = (Month)task.month + " " + task.day.ToString();
        dateText.text += (task.day % 10) switch
        {
            1 => "st",
            2 => "nd",
            3 => "rd",
            _ => "th"
        };
    }
}
