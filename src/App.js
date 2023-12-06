import logo from "./logo.svg";
import "./App.css";

import Sider from "./Sider";
import { Route, Routes } from "react-router-dom";
import Mytask from "./content/Mytask";
import Star from "./content/Star";
import Complete from "./content/Complete";
import Trash from "./content/Trash";

function App() {
  return (
    <div className="bg-[#F1F5F9] h-[100vh] p-6 flex gap-[20px]">
      <Sider />
      <Routes>
        <Route path="/" element={<Mytask />} />
        <Route path="/starred" element={<Star />} />
        <Route path="/completed" element={<Complete />} />
        <Route path="/trash" element={<Trash />} />
      </Routes>
    </div>
  );
}

export default App;
