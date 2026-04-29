const messages = [
  { role: "user", content: "请总结这份财报" },
  { role: "assistant", content: "" },
];

function appendAssistantChunk(chunk) {
  const lastMessage = messages[messages.length - 1];
  lastMessage.content += chunk;
  console.log("当前 assistant 消息:", lastMessage.content);
}

async function simulateStream() {
  const chunks = ["公司", "本季度", "利润", "同比增长", "18%。"];

  for (const chunk of chunks) {
    appendAssistantChunk(chunk);
    await new Promise((resolve) => setTimeout(resolve, 200));
  }
}

simulateStream();
