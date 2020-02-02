<template>
  <div id="app">
    <h1>Test</h1>
    <p>List Uploaded Files.</p>

    <div v-for="file in uploadedFiles" :key="file.id">
      <li>
        <a :href="file">{{ file }}</a>
      </li>
    </div>
  </div>
</template>

<script>
import api from "../Api.js";

export default {
  name: "test",
  data() {
    return {
      num: null,
      uploadedFiles: null
    };
  },
  methods: {
    getListUploadedFiles() {
      api
        .listUploadedFiles()
        .then(res => {
          console.log(res.data);
          this.uploadedFiles = res.data;
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    api
      .get("/uploadedfiles")
      .then(res => {
        console.log(JSON.parse(JSON.stringify(res.data)));
        this.uploadedFiles = res.data;
      })
      .catch(e => {
        console.log(e);
      });
  }
};
</script>