import React, { useEffect, useState } from "react";
import "./Sider.css";
import { Link, useLocation } from "react-router-dom";
import tagAPi from "./api/TagAPI";
import { Button, Modal } from "antd";
import userAPI from "./api/UserAPI";
import { DatePicker, Space } from "antd";
import taskAPi from "./api/TaskAPI";

const Sider = () => {
  const { pathname } = useLocation();
  const [tasks, setTasks] = useState([]);
  const [tags, setTags] = useState([]);
  const [users, setUsers] = useState([]);
  const [isTagDropdownOpen, setIsTagDropdownOpen] = useState(false);
  const [isUserDropdownOpen, setIsUserDropdownOpen] = useState(false);
  const [title, setTitle] = useState("");
  const [date, setDate] = useState("");
  const [desc, setDesc] = useState("");

  useEffect(() => {
    const fetchTagList = async () => {
      try {
        const response = await tagAPi.getAll();
        // console.log(response);
        setTags(response);
      } catch (error) {
        console.log("Failed: ", error);
      }
    };
    fetchTagList();
  }, []);

  useEffect(() => {
    const fetchUserList = async () => {
      try {
        const response = await userAPI.getAll();
        // console.log(response);
        setUsers(response);
      } catch (error) {
        console.log("Failed: ", error);
      }
    };
    fetchUserList();
  }, []);

  //create new task
  const handleAdd = async () => {
    try {
      const respone = await taskAPi.createTask();
      // console.log(respone);
      setTasks([...tasks, respone]);
      setIsModalOpen(false);
    } catch (error) {
      console.log("Error:", error);
    }
  };

  //modal
  const [isModalOpen, setIsModalOpen] = useState(false);
  const showModal = () => {
    setIsModalOpen(true);
  };
  const handleCancel = () => {
    setIsModalOpen(false);
  };

  const afterCloseHandler = () => {
    setDate("");
    setTitle("");
    setSelectedTag("");
    setSelectedUser("");
    setDesc("");
  };

  // tag
  const handleTagClick = () => {
    setIsTagDropdownOpen(!isTagDropdownOpen);
    setIsUserDropdownOpen(false);
  };

  const [selectedTag, setSelectedTag] = useState([]);
  const handleLiTagClick = (selectedTag) => {
    setSelectedTag((prev) => [...prev, selectedTag.name]);
    const updatedTags = tags.filter((tag) => tag.tagId !== selectedTag.tagId);
    setTags(updatedTags);
    // console.log(selectedUser);
  };

  // user
  const handleUserClick = () => {
    setIsUserDropdownOpen(!isUserDropdownOpen);
    setIsTagDropdownOpen(false);
  };

  const [selectedUser, setSelectedUser] = useState([]);
  const handleLiClick = (selectedUser) => {
    setSelectedUser((prev) => [...prev, selectedUser.name]);
    const updatedUsers = users.filter(
      (user) => user.userId !== selectedUser.userId
    );
    setUsers(updatedUsers);
    console.log(selectedUser);
  };

  //due date
  const onChange = (value) => {
    console.log("value due date: ", value);
    setDate(value);
  };

  return (
    <div className=" p-6 bg-white lg:w-[20%] rounded-lg shadow-sm">
      <button
        onClick={showModal}
        type="button"
        className="btn flex items-center justify-center bg-[#0F172A] text-white py-3 px-6 rounded-[4px] w-full transition-all mb-6"
      >
        <span className="text-[20px]">
          <i className="fa-solid fa-plus text-white"></i>
        </span>
        <span className="pl-3  font-semibold">Add Task</span>
      </button>
      <ul>
        <li className={pathname === "/" ? "active" : ""}>
          <Link to="/">
            <i className="fa-regular fa-image"></i>
            <p>My Task</p>
          </Link>
        </li>
        <li className={pathname === "/starred" ? "active" : ""}>
          <Link to="/starred">
            <i className="fa-regular fa-star"></i>
            <p>Starred</p>
          </Link>
        </li>
        <li className={pathname === "/completed" ? "active" : ""}>
          <Link to="/completed">
            <i className="fa-solid fa-check-to-slot"></i>
            <p>Completed</p>
          </Link>
        </li>
        <li className={pathname === "/trash" ? "active" : ""}>
          <Link to="/trash">
            <i className="fa-solid fa-trash-can"></i>
            <p>Trash</p>
          </Link>
        </li>
      </ul>
      <p className="text-[12px] text-[#1e293b] uppercase font-bold py-4">
        tags
      </p>
      <ul>
        {tags &&
          tags.map((tag) => (
            <li
              key={tag.tagId}
              className="flex items-center text-[#475569] py-2"
            >
              <div
                style={{
                  backgroundColor: `${tag.color}`,
                  width: "8px",
                  height: "8px",
                  borderRadius: "50%",
                }}
              ></div>
              <span className="ml-2">{tag.name}</span>
            </li>
          ))}
      </ul>
      <Modal
        afterClose={afterCloseHandler}
        closable={false}
        open={isModalOpen}
        onCancel={handleCancel}
        footer={[
          <button
            key="submit"
            className="modal_submit bg-[#0f172a] text-white py-3 px-6 rounded text-[15px] font-semibold text-center mr-7 mb-8"
            onClick={handleAdd}
          >
            Submit
          </button>,
        ]}
      >
        <header className="flex items-center justify-between bg-[#0E1628] w-full px-[20px] overflow-hidden rounded-t-md">
          <p className="font-normal text-white text-lg ">Add Task</p>
          <span
            onClick={handleCancel}
            className="text-white text-lg cursor-pointer"
          >
            <i class="fa-solid fa-x"></i>
          </span>
        </header>
        <div className="content mt-8 mx-6">
          <label htmlFor="title">Title</label>
          <input
            type="text"
            placeholder="Enter title"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          ></input>
          <label htmlFor="assignee">Assignee</label>
          {/* user */}
          <span className="relative" onClick={handleUserClick}>
            <input
              placeholder="Select..."
              className=""
              value={selectedUser}
            ></input>
            <i class="fa-solid fa-chevron-down"></i>
            {isUserDropdownOpen && (
              <ul className="absolute top-[47px] border border-[#e2e8f0] w-full rounded-md overflow-hidden bg-white z-50">
                {users.map((user) => (
                  <li
                    key={user.userId}
                    className="hover:bg-[#a0aec0] text-[#0f172a] py-2 px-3 text-base flex item-center"
                    onClick={() => handleLiClick(user)}
                  >
                    <img
                      src={user.avatar}
                      alt="avatar"
                      className="w-[28px] h-[28px]"
                    />
                    <p className="ml-4">{user.name}</p>
                  </li>
                ))}
              </ul>
            )}
          </span>
          <label htmlFor="duedate">Due Date</label>
          <Space direction="vertical" style={{ width: "100%" }}>
            <DatePicker onChange={onChange} value={date} />
          </Space>
          <label htmlFor="tag">Tag</label>
          <span className="relative" onClick={handleTagClick}>
            <input placeholder="Select..." value={selectedTag}></input>
            <i class="fa-solid fa-chevron-down"></i>

            {isTagDropdownOpen && (
              <ul className="absolute top-[47px] border border-[#e2e8f0] w-full rounded-md overflow-hidden bg-white z-50">
                {tags.map((tag) => (
                  <li
                    key={tag.tagId}
                    className="hover:bg-[#a0aec0] text-[#0f172a] py-2 px-3 text-base"
                    onClick={() => handleLiTagClick(tag)}
                  >
                    {tag.name}
                  </li>
                ))}
              </ul>
            )}
          </span>
          <label htmlFor="description">Description</label>
          <textarea
            value={desc}
            onChange={(e) => setDesc(e.target.value)}
            placeholder="Description"
            className="py-2 h-[80px]"
          ></textarea>
        </div>
      </Modal>
    </div>
  );
};

export default Sider;
