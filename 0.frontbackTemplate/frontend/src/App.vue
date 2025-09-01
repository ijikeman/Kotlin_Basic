<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const message = ref('Loading...')

onMounted(async () => {
  try {
    const response = await axios.get('/api/greeting')
    message.value = response.data.text
  } catch (error) {
    console.error('Error fetching message:', error)
    message.value = 'Failed to load message from backend.'
  }
})
</script>

<template>
  <main>
    <h1>Frontend</h1>
    <p>Message from backend: {{ message }}</p>
  </main>
</template>
