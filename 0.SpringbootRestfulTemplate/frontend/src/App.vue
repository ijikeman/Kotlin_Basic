<template>
  <div>
    <h1>{{ message }}</h1>
    <button @click="fetchMessage('us')">Say Hello</button>
    <button @click="fetchMessage('jp')">こんにちは</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      message: 'Loading...'
    };
  },
  methods: {
    fetchMessage(lang) {
      this.message = 'Loading...';
      const url = `/api/hello/${lang}`;
      axios.get(url)
        .then(response => {
          this.message = response.data;
        })
        .catch(error => {
          console.error('Error fetching data:', error);
          this.message = `Failed to load message from backend for lang: ${lang}.`;
        });
    }
  },
  mounted() {
    this.fetchMessage('us');
  }
};
</script>

<style>
button {
  margin-right: 10px;
}
</style>
