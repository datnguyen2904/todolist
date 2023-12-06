import React, { useEffect, useState } from "react";
import taskAPi from "../api/TaskAPI";

const Trash = () => {
  const [tasks, setTasks] = useState([]);
  const [task, setTask] = useState("");

  const handleComplete = async (id) => {
    try {
      // Update the local state
      setTasks((prevTasks) =>
        prevTasks.map((task) =>
          task.taskId === id ? { ...task, complete: !task.complete } : task
        )
      );
      const respon = await taskAPi.updateComplete(id, {
        complete: !task.complete,
      });
      console.log("complete:", respon.complete);
    } catch (error) {
      console.log("Error:", error);
    }
  };

  const handleStar = async (id) => {
    try {
      // Update the local state
      setTasks((prevTasks) =>
        prevTasks.map((task) =>
          task.taskId === id ? { ...task, important: !task.important } : task
        )
      );
      const respon = await taskAPi.updateImportant(id, {
        important: !task.important,
      });
      console.log("important:", respon.important);
    } catch (error) {
      console.log("Error:", error);
    }
  };

  const handleHide = async (id) => {
    try {
      // Update the local state
      setTasks((prevTasks) =>
        prevTasks.map((task) =>
          task.taskId === id ? { ...task, hide: !task.hide } : task
        )
      );
      const respon = await taskAPi.updateHide(id, {
        hide: !task.hide,
      });
      console.log("hide:", respon.hide);
    } catch (error) {
      console.log("Error:", error);
    }
  };
  useEffect(() => {
    const fetchtTaskStarredList = async () => {
      try {
        const respone = await taskAPi.getAllByTrash();
        // console.log(respone);
        setTasks(respone);
      } catch (error) {
        console.log("Error:", error);
      }
    };
    fetchtTaskStarredList();
  }, []);

  return (
    <div className="star bg-white w-full rounded-lg ">
      <header className="border-b border-slate-100">
        <i class="fa-solid fa-magnifying-glass "></i>
        <input
          className="outline-none focus:border-none ml-1"
          placeholder="Search task"
        />
        <i class="fa-solid fa-list"></i>
      </header>
      <ul>
        {tasks &&
          tasks.map((task) => (
            <li
              key={task.taskId}
              className="task-list border-b border-slate-100 last:border-none flex items-center"
            >
              <i
                className="fa-solid fa-circle-check text-[17px] transition-all"
                onClick={() => handleComplete(task.taskId)}
                style={task.complete === true ? { color: "green" } : {}}
              ></i>
              <i
                className="fa-solid fa-star text-[17px] transition-all"
                onClick={() => handleStar(task.taskId)}
                style={task.important === true ? { color: "#FFCE30" } : {}}
              ></i>
              <p
                style={
                  task.complete === true
                    ? { textDecoration: "line-through" }
                    : {}
                }
              >
                {task.title}
              </p>
              <div className="flex items-center gap-3 justify-end">
                <ul className="flex items-center ">
                  {task.userAvatars &&
                    task.userAvatars.map((userAvatar, index) => (
                      <li
                        key={index}
                        style={task.complete === true ? { opacity: "0.5" } : {}}
                      >
                        <img
                          className="border border-[#a0aec0] rounded-[50%] w-[28px] h-[28px]"
                          src={userAvatar.avatar}
                          alt={`User ${index + 1}`}
                        />
                      </li>
                    ))}
                </ul>
                <ul className="flex items-center justify-center gap-2">
                  {task.tagNames &&
                    task.tagNames.map((tagName, index) => (
                      <li key={index}>
                        <div>{tagName.name}</div>
                      </li>
                    ))}
                </ul>
                <i className="fa-regular fa-pen-to-square text-sm"></i>
                <i
                  onClick={() => handleHide(task.taskId)}
                  className="fa-solid fa-trash text-sm"
                ></i>
              </div>
            </li>
          ))}
      </ul>
    </div>
  );
};

export default Trash;
