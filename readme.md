<div align="center">

<img src="assets/banner.svg" alt="XintuWhiteList" width="100%">

# XintuWhiteList

**QQ 验证码白名单插件** —— 玩家进服后弹出验证码，在 QQ 群内 @机器人 完成验证方可游玩，可与 AuthMe 联动。

![Platform](https://img.shields.io/badge/Platform-Spigot%20%2F%20Paper-62bda8?style=flat-square&logo=minecraft&logoColor=white)
![Minecraft](https://img.shields.io/badge/MC-1.20.x-8a9a5b?style=flat-square)
![Java](https://img.shields.io/badge/Java-8%2B-f89820?style=flat-square&logo=openjdk&logoColor=white)
![AuthMe](https://img.shields.io/badge/softdepend-AuthMe-e2b90f?style=flat-square)

[功能](#-功能) · [配置](#️-配置) · [API](#-api) · [构建](#-构建)

</div>

## ✨ 功能

- **进服验证**：玩家加入时以 Title 显示验证码（`验证码 {0}` + 订阅副标题），需要在绑定 QQ 群内 @机器人 发送验证码，或输入 `/register <密码>` 完成注册
- **AuthMe 联动**：softdepend AuthMe，未验证玩家走登录流程，`login-prompt` 自定义提示文案
- **白名单 API**：对外暴露 `WhiteListAPI`，其他插件可查询/修改白名单状态
- **全文案可配**：注册提示、登录提示、验证成功语均在配置文件中调整

## ⚙️ 配置

`config.yml`：

```yaml
default-password: "yC[c=a8G"     # 默认注册密码
login-prompt: "登录"              # AuthMe 登录提示关键字
register-prompt: "&b📢 &f请输入您的&cQQ号码 &f或 输入&c/register <密码> 密码 &f完成注册"
title-code: "验证码 {0}"          # Title 主文案
subtitle-code: "请在群内 @机器人 <验证码> 完成发送"
login-mssage: "请在群内发送 @机器人 登录 或 输入/login <密码> 完成登录"
login-success: "您已成功登录服务器，祝您游戏愉快！"
```

## 🧩 API

```java
WhiteListAPI api = ...;  // 白名单查询接口，供其他插件集成
```

示例用法见 `src/main/java/org/windy/xintuWhiteList/example.java`。

## 🔨 构建

```bash
./gradlew build
```

---

配套项目：[XintuChat](https://github.com/windy664/XintuChat)（QQ 群 ↔ 游戏聊天互联）
