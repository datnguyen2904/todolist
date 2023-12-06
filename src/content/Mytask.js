import React, { useEffect, useState } from "react";
import "./Mytask.css";
import taskAPi from "../api/TaskAPI";

const Mytask = () => {
  const [tasks, setTasks] = useState([]);
  const [task, setTask] = useState("");
  const [sort, setSort] = useState(false);

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
    const fetchtTaskList = async () => {
      try {
        const respone = await taskAPi.getAll();
        // console.log(respone);
        setTasks(respone);
      } catch (error) {
        console.log("Error:", error);
      }
    };
    fetchtTaskList();
  }, []);

  // sort
  const handleSort = () => {
    setSort(!sort);
  };
  return (
    <div className="mytask bg-white w-full rounded-lg ">
      <header className="border-b border-slate-100 relative">
        <i class="fa-solid fa-magnifying-glass "></i>
        <input
          className="outline-none focus:border-none ml-1"
          placeholder="Search task"
        />
        <i onClick={handleSort} class="fa-solid fa-list"></i>
        {sort && (
          <ul className="absolute sort right-3 top-[72%] border border-slate-100 z-50 bg-white rounded-md overflow-hidden">
            <li className="p-1 px-6 hover:bg-[#0F172A] hover:text-white flex items-center gap-2">
              <i class="fa-solid fa-arrow-up-wide-short"></i>
              <span>Reset Sort</span>
            </li>
            <li className="p-1 px-6 hover:bg-[#0F172A] hover:text-white flex items-center gap-2">
              <i class="fa-solid fa-arrow-up-a-z"></i>
              <span>Sort A-Z</span>
            </li>
            <li className="p-1 px-6 hover:bg-[#0F172A] hover:text-white flex items-center gap-2 ">
              <i class="fa-solid fa-arrow-up-z-a"></i>
              <span>Sort Z-A</span>
            </li>
          </ul>
        )}
      </header>
      <ul>
        {tasks &&
          tasks.map((task) => (
            <li
              key={task.taskId}
              className="task-list border-b border-slate-100 last:border-none flex items-center"
              style={task.hide === true ? { display: "none" } : {}}
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

export default Mytask;
