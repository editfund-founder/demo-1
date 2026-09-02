# demo-1-android

这是一个最小的 Android 应用示例：在输入框输入 URL，点击 `Fetch` 会使用 OkHttp 发起 HTTP GET 并显示状态码与响应体。

运行要求
- 安装 JDK 17（或使用工作流中的 JDK 17），并使用 Gradle 8.7（工作流会生成 wrapper）。

构建与运行（本地）
```bash
# 生成或更新 Gradle wrapper（只需运行一次）
./gradlew wrapper --gradle-version 8.7

# 构建 release APK
./gradlew :app:assembleRelease
```

输出 APK 在 `app/build/outputs/apk/release/`，GitHub Actions 工作流会将其上传并在主分支上创建 release。

若你之前需要保留桌面 (Swing) 应用，请在迁移前创建单独分支或备份代码。
