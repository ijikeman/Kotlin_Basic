import { describe, it, expect, vi, beforeEach } from 'vitest';
import { mount } from '@vue/test-utils';
import axios from 'axios';
import App from '../App.vue';

// Helper function to flush pending promises
const flushPromises = () => new Promise(resolve => setTimeout(resolve, 0));

// Mock axios
vi.mock('axios');

describe('App.vue', () => {
  beforeEach(() => {
    // Reset mocks before each test
    vi.resetAllMocks();
  });

  it('renders the initial message', () => {
    // Mock the axios call that happens on mount
    axios.get.mockResolvedValue({ data: 'Hello' });
    const wrapper = mount(App);
    expect(wrapper.find('h1').text()).toBe('Loading...');
  });

  it('fetches and displays a message on mount (success)', async () => {
    const message = 'Hello from the backend!';
    axios.get.mockResolvedValue({ data: message });

    const wrapper = mount(App);

    // Wait for the promise from the mount hook to resolve
    await flushPromises();

    expect(wrapper.find('h1').text()).toBe(message);
    expect(axios.get).toHaveBeenCalledWith('/api/hello/us');
  });

  it('displays an error message on mount (failure)', async () => {
    // Mock the failed response
    axios.get.mockRejectedValue(new Error('Network Error'));

    const wrapper = mount(App);

    // Wait for the promise from the mount hook to reject
    await flushPromises();

    expect(wrapper.find('h1').text()).toBe('Failed to load message from backend for lang: us.');
  });

  it('fetches a new message when "こんにちは" button is clicked', async () => {
    const initialMessage = 'Initial message';
    const newMessage = 'こんにちは from the backend!';

    // Mock the initial call on mount
    axios.get.mockResolvedValueOnce({ data: initialMessage });
    const wrapper = mount(App);
    await flushPromises(); // Wait for mount promise

    // Mock the second call for the button click
    axios.get.mockResolvedValueOnce({ data: newMessage });

    // Find the 'jp' button and click it
    await wrapper.findAll('button')[1].trigger('click');
    await flushPromises(); // Wait for click promise

    expect(wrapper.find('h1').text()).toBe(newMessage);
    expect(axios.get).toHaveBeenCalledTimes(2);
    expect(axios.get).toHaveBeenCalledWith('/api/hello/jp');
  });

  it('fetches a new message when "Say Hello" button is clicked', async () => {
    const initialMessage = 'Initial message';
    const newMessage = 'Hello again!';

    // Mock the initial call on mount
    axios.get.mockResolvedValueOnce({ data: initialMessage });
    const wrapper = mount(App);
    await flushPromises(); // Wait for mount promise

    // Mock the second call for the button click
    axios.get.mockResolvedValueOnce({ data: newMessage });

    // Find the 'us' button and click it
    await wrapper.findAll('button')[0].trigger('click');
    await flushPromises(); // Wait for click promise

    expect(wrapper.find('h1').text()).toBe(newMessage);
    expect(axios.get).toHaveBeenCalledTimes(2);
    expect(axios.get).toHaveBeenCalledWith('/api/hello/us');
  });
});
