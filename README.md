# 星之勇者（Star Hero）
一个使用 Java + JavaFX 开发的放置类 RPG 挂机游戏。  
玩家的角色会自动攻击怪物，获得金币与装备材料，通过升级属性与装备不断变强，挑战更高关卡。

本项目旨在提供一个完整的 Idle RPG 架构示例，适合学习游戏开发、JavaFX UI、后台线程（Game Loop）等技术。

---

## 🧩 游戏玩法简介

### 1. 自动战斗（核心循环）
- 角色每秒自动攻击怪物
- 怪物也会自动攻击角色
- 击败怪物可获得 **金币 + 装备材料**
- 玩家死亡会自动复活（挂机游戏不惩罚玩家）
- 击败怪物 → 自动进入下一关 → 出现更强的怪物

### 2. 属性提升
使用金币提升：
- Attack（攻击力）
- Defense（防御力）
- MaxHP（最大生命）
- HP Regen（可选）

属性越高，推关越快、挂机收益越多。

### 3. 装备系统
怪物掉落 “装备材料（Gear Shard）”，用于强化装备：
- 武器（提升攻击力）
- 防具（提升防御）
- 饰品（提升生命）

装备等级越高，收益递增。

### 4. 关卡系统（Stage）
- 每一关都有等级、血量和奖励的增长
- 推关越高，收益越高
- 没有上限，可无限挂机

---

## 🧱 技术栈

### **语言**
- Java 21

### **UI 框架**
- JavaFX 21

### **核心技术**
- UI 事件驱动（JavaFX）
- 后台线程实现游戏循环（GameLoop Thread）
- MVC 风格的游戏架构（model / view / controller）
- 资源管理（金币、装备材料）
- 自动战斗逻辑

---

## 📁 项目文件结构（建议）
```
src/
└── starhero/
    ├── Main.java                 # JavaFX 主入口
    ├── game/
    │    ├── GameLoop.java        # 后台战斗循环
    │    ├── StageManager.java    # 管理关卡
    │    └── EventBus.java        # 可选：UI事件通知
    │
    ├── model/
    │    ├── Player.java          # 玩家属性与逻辑
    │    ├── Monster.java         # 怪物属性与逻辑
    │    ├── Equipment.java       # 装备类（武器/防具/饰品）
    │    ├── Inventory.java       # 背包（可选）
    │    └── Resource.java        # 金币/材料等资源类
    │
    ├── ui/
    │    ├── MainWindow.java      # 主界面
    │    ├── UpgradePanel.java    # 属性升级界面
    │    └── EquipmentPanel.java  # 装备页面
    │
    └── util/
         └── Format.java          # 格式化工具（HP、数字等）
```

---

## 🚀 开发进度（大概路线）

- [x] 确定游戏整体架构
- [ ] JavaFX UI 基础搭建
- [ ] 创建 Player / Monster 基础类
- [ ] 实现 Game Loop（后台线程）
- [ ] 自动战斗系统
- [ ] UI 属性显示更新
- [ ] 属性升级系统
- [ ] 装备强化系统
- [ ] 关卡推进
- [ ] 战斗日志系统
- [ ] 视觉优化（HP 条、图片、动画）
- [ ] 存档系统（JSON）
- [ ] 完整发布

---

## 📝 许可证
本项目属于学习项目，仅用于个人学习用途，可自由修改与扩展。

---

欢迎 Star 支持一下！希望你能在开发过程中逐渐掌握 JavaFX 与游戏开发技巧！🌟