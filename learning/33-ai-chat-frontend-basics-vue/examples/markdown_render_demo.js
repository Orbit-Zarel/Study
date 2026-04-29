const markdownText = `
# 财报摘要

- 营收同比增长 18%
- 毛利率提升 2.1 个百分点

\`\`\`python
print("hello report")
\`\`\`
`;

function fakeMarkdownRender(text) {
  return text
    .replace(/^# (.*)$/gm, "<h1>$1</h1>")
    .replace(/^- (.*)$/gm, "<li>$1</li>")
    .replace(/\`\`\`python([\s\S]*?)\`\`\`/g, "<pre><code>$1</code></pre>");
}

const html = fakeMarkdownRender(markdownText);

console.log("原始 Markdown:");
console.log(markdownText);
console.log("\n渲染后的 HTML:");
console.log(html);
