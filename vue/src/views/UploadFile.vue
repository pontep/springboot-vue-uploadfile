<template>
  <div id="app">
    <h1>Upload File.</h1>
    <p>This is an uploading file page.</p>
    <div>
      <input type="text" name="name" v-model="name" />
      <input type="file" name="file" @change="onFileSelected" />
      <button @click="onUpload">Upload</button>
    </div>
    <div>{{ message }}</div>
  </div>
</template>

<script>
import api from '../Api.js';

export default {
  name: 'uploadfile',
  data() {
    return {
      name: '',
      selectedFile: null,
      response: null,
      message: null,
    };
  },
  methods: {
    onFileSelected(event) {
      this.selectedFile = event.target.files[0];
    },
    onUpload() {
      const fd = new FormData();
      fd.append('file', this.selectedFile);
      fd.append('name', this.name);

      var msg = null;
      api
        .post('/upload3', fd)
        .then((response) => {
          console.log(response);
          msg = response.data;
        })
        .catch(function(error) {
          if (error.response) {
            // The request was made and the server responded with a status code
            // that falls out of the range of 2xx
            // console.log(error.response.data);
            // console.log(error.response.status);
            // console.log(error.response.headers);
            msg = error.response.data.message;
          } else if (error.request) {
            // The request was made but no response was received
            // `error.request` is an instance of XMLHttpRequest in the browser and an instance of
            // http.ClientRequest in node.js
            console.log(error.request);
          } else {
            // Something happened in setting up the request that triggered an Error
            console.log('Error', error.message);
          }
          console.log(error.config);
        })
        .finally(() => {
          this.message = msg;
        });
    },
  },
};
</script>

<style></style>
