function solution(word) {
  const vowels = ['A', 'E', 'I', 'O', 'U'];
  let count = 0;
  let found = false;

  function dfs(currentWord) {
    if (currentWord === word) {
      found = true;
      return;
    }
    if (currentWord.length >= 5) {
      return;
    }
    for (let i = 0; i < vowels.length; i++) {
      if (found) return;
      count++;
      dfs(currentWord + vowels[i]);
    }
  }

  dfs('');
  return count;
}