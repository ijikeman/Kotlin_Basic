<template>
  <div>
    <h1>{{ message }}</h1>
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
  mounted() {
    axios.get('/api/')
      .then(response => {
        this.message = response.data;
      })
      .catch(error => {
        console.error('Error fetching data:', error);
        this.message = 'Failed to load message from backend.';
      });
  }
};
</script>
