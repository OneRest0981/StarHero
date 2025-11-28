# 星之勇者 - 开发任务列表（TASK）

本任务表用于指导整个项目的开发过程，分为阶段目标与每日任务。

---

# 📌 阶段 1：框架搭建（UI + 系统基础）
目标：跑起来 JavaFX 窗口、构建基础结构、准备游戏循环

## Task 1：JavaFX 项目初始化
- 创建项目结构（按照 README）
- 运行 JavaFX Window（空窗口即可）
- 创建 MainWindow（主界面）

## Task 2：UI 事件驱动理解
- 添加按钮（例如“开始游戏”）
- 点击按钮 → 控制台输出
- 理解 JavaFX 事件机制

## Task 3：后台线程（Game Loop）框架
- 创建 GameLoop.java
- 让线程每秒运行一次（打印日志即可）
- 学习 Platform.runLater 更新 UI

---

# 📌 阶段 2：核心战斗系统
目标：玩家对怪物、怪物对玩家、战斗循环

## Task 4：Player 类
- attack / defense / maxHP / currentHP
- attack() 方法
- takeDamage() 方法

## Task 5：Monster 类
- 随关卡自动生成属性
- isDead() 判定
- deathReward（金钱）

## Task 6：战斗循环（正式）
- 每秒调用 player.attack(monster)
- 每秒怪物反击 player
- 玩家死亡 → 自动满血
- 怪物死亡 → 奖励 + 新怪物

---

# 📌 阶段 3：资源与成长系统

## Task 7：金币系统
- gainGold()
- upgradeAttack()
- upgradeDefense()
- upgradeMaxHP()
- UI 绑定按钮

## Task 8：装备材料与装备系统
- 设计强化公式
- 创建 Equipment 类
- 武器 / 防具 / 饰品
- 强化成功 → 数值成长

---

# 📌 阶段 4：关卡系统

## Task 9：StageManager
- stage++
- 计算怪物属性（血量、攻击、奖励）
- UI 显示当前关卡

---

# 📌 阶段 5：UI 完善

## Task 10：UI 显示
- HP 条（玩家 / 怪物）
- 属性显示
- 战斗日志窗口
- 金币和材料显示

## Task 11：界面切换
- 主界面
- 装备界面
- 升级界面

---

# 📌 阶段 6：最终整合

## Task 12：存档系统
- 保存 Player、装备、关卡到 JSON
- 读取存档继续游戏

## Task 13：GUI 美化
- CSS 美化
- 图片资源加入
- 怪物图 / 英雄图 / 图标

---

# 🌟 终极目标：发布你的第一个 Java 挂机 RPG 游戏！

你将完成一个具有：
- 自动战斗
- 装备
- 属性成长
- 关卡推进
- UI
- 存档

的原创游戏 —— **星之勇者（Star Hero）**。

这是非常棒的作品！