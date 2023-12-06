import axiosClient from "./axiosClient";

const taskAPi = {
  getAll: (params) => {
    const url = "/tasks/all";
    return axiosClient.get(url, {
      params,
    });
  },
  getAllByStarred: (params) => {
    const url = "/tasks/all/important";
    return axiosClient.get(url, {
      params,
    });
  },
  getAllByCompleted: (params) => {
    const url = "/tasks/all/complete";
    return axiosClient.get(url, {
      params,
    });
  },
  getAllByTrash: (params) => {
    const url = "/tasks/all/hide";
    return axiosClient.get(url, {
      params,
    });
  },

  updateImportant: (id) => {
    const url = `/update_important?id=${id}`;
    return axiosClient.put(url, { id });
  },
  updateComplete: (id) => {
    const url = `/update_complete?id=${id}`;
    return axiosClient.put(url, { id });
  },
  updateHide: (id) => {
    const url = `/update_hide?id=${id}`;
    return axiosClient.put(url, { id });
  },
};
export default taskAPi;
