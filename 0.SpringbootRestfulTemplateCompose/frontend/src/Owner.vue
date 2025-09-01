<template>
  <div>
    <h1>Owner Management</h1>

    <!-- Form for adding/editing owners -->
    <form @submit.prevent="saveOwner">
      <input type="hidden" v-model="owner.id">
      <input type="text" v-model="owner.name" placeholder="Name" required>
      <input type="text" v-model="owner.address" placeholder="Address" required>
      <button type="submit">Save</button>
      <button type="button" @click="resetForm">Cancel</button>
    </form>

    <!-- Table to display owners -->
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Address</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="owner in owners" :key="owner.id">
          <td>{{ owner.id }}</td>
          <td>{{ owner.name }}</td>
          <td>{{ owner.address }}</td>
          <td>
            <button @click="editOwner(owner)">Edit</button>
            <button @click="deleteOwner(owner.id)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      owners: [],
      owner: {
        id: null,
        name: '',
        address: ''
      }
    };
  },
  methods: {
    fetchOwners() {
      axios.get('/api/owners')
        .then(response => {
          this.owners = response.data;
        })
        .catch(error => {
          console.error('Error fetching owners:', error);
        });
    },
    saveOwner() {
      if (this.owner.id) {
        // Update owner
        axios.put(`/api/owners/${this.owner.id}`, this.owner)
          .then(() => {
            this.fetchOwners();
            this.resetForm();
          })
          .catch(error => {
            console.error('Error updating owner:', error);
          });
      } else {
        // Add new owner
        axios.post('/api/owners', this.owner)
          .then(() => {
            this.fetchOwners();
            this.resetForm();
          })
          .catch(error => {
            console.error('Error adding owner:', error);
          });
      }
    },
    editOwner(owner) {
      this.owner = { ...owner };
    },
    deleteOwner(id) {
      axios.delete(`/api/owners/${id}`)
        .then(() => {
          this.fetchOwners();
        })
        .catch(error => {
          console.error('Error deleting owner:', error);
        });
    },
    resetForm() {
      this.owner = {
        id: null,
        name: '',
        address: ''
      };
    }
  },
  mounted() {
    this.fetchOwners();
  }
};
</script>

<style>
table {
  width: 100%;
  border-collapse: collapse;
}
th, td {
  border: 1px solid #ddd;
  padding: 8px;
}
th {
  background-color: #f2f2f2;
}
form {
  margin-bottom: 20px;
}
</style>
