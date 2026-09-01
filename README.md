# demo-1-http-get

简单的 Kotlin Swing 应用：点击按钮发送 HTTP GET 并显示返回内容。

运行要求
- 安装 JDK 11+ 和 Gradle（或使用 Gradle Wrapper）。

构建与运行
```bash
cd /home/pi/Downloads/demo-1-http-get
gradle run
# 或者如果有 gradlew：
./gradlew run
```

默认 URL 在界面顶部，示例为 `https://httpbin.org/get`。点击 `Fetch` 会在下方文本框显示状态码与返回体。
