import axiosClient from "./axiosClient";

const tagAPi = {
  getAll: (params) => {
    const url = "/tags/all";
    return axiosClient.get(url, {
      params,
    });
  },
};
export default tagAPi;
