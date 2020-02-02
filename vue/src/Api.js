import axios from "axios";

// const SERVER_URL = "http://localhost:9000";

// const instance = axios.create({
//   baseURL: SERVER_URL,
//   timeout: 1000,
//   headers: {
//     "Content-type": "application/json"
//   }
// });

export default axios.create({
  baseURL: "http://localhost:9000/",
  headers: {
    "Content-type": "application/json"
  }
});

// export default {
//   test: num => {
//     return "Your input number = " + num;
//   },
//   listUploadedFiles: () =>
//     instance.get("/", {
//       transformResponse: [
//         function(data) {
//           return data ? JSON.parse(data) : data;
//         }
//       ]
//     })
// };
