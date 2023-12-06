import axiosClient from "./axiosClient";

const userAPI = {
  getAll: (params) => {
    const url = "/users/all";
    return axiosClient.get(url, {
      params,
    });
  },
};
export default userAPI;
