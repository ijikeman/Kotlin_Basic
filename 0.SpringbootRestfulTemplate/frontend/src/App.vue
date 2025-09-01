<template>
  <div>
    <!-- メッセージを表示 -->
    <h1>{{ message }}</h1>
    <!-- ボタンをクリックすると fetchMessage メソッドを呼び出す -->
    <button @click="fetchMessage('us')">Say Hello</button>
    <button @click="fetchMessage('jp')">こんにちは</button>
  </div>
</template>

<script>
// axiosをインポート
import axios from 'axios';

export default {
  // コンポーネントのデータ
  data() {
    return {
      // 表示するメッセージ
      message: 'Loading...'
    };
  },
  // メソッド
  methods: {
    // メッセージをフェッチするメソッド
    fetchMessage(lang) {
      // メッセージをローディング中に設定
      this.message = 'Loading...';
      // APIのURL
      const url = `/api/hello/${lang}`;
      // axiosでGETリクエストを送信
      axios.get(url)
        .then(response => {
          // レスポンスのデータをメッセージに設定
          this.message = response.data;
        })
        .catch(error => {
          // エラーをコンソールに出力
          console.error('Error fetching data:', error);
          // エラーメッセージを設定
          this.message = `Failed to load message from backend for lang: ${lang}.`;
        });
    }
  },
  // コンポーネントがマウントされたときに呼び出される
  mounted() {
    // usのメッセージをフェッチ
    this.fetchMessage('us');
  }
};
</script>

<style>
/* ボタンのスタイル */
button {
  margin-right: 10px;
}
</style>
