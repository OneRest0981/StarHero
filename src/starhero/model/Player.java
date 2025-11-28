package starhero.model;

import java.math.BigDecimal;

public class Player {

    // 信息
    private int id;
    private String name;

    // 等级经验
    private int level;
    private long exp;
    private long expToNextLevel;
    private BigDecimal gold;

    // 星星 职业
    private Star star;

    // 属性点
    private int strPoint;
    private int agiPoint;
    private int vitPoint;
    private int lukPoint;
    private int freePoints;

    // 属性结构
    private Stats baseStats; // 基础属性
    private Stats bonusStats; // 增幅数值
    private Stats finalStats; // 最终属性

    // 战斗状态
    private double currentHp;

    // 背包
    private Inventory inventory;

    // 装备栏
    private Item weapon;
    private Item helmet;
    private Item chestplate;
    private Item leggings;
    private Item boots;
    private Item ring;

    /**
     *
     * @param id id
     * @param name 玩家名
     */
    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 方法

    // 基础


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public void addMoney(BigDecimal money){
        this.gold = this.gold.add(money);
    }

    public void setGold(BigDecimal gold){
        this.gold = gold;
    }

    public BigDecimal getGold() {return this.gold;}

    // 等级
    public int getLevel() { return level; }
    public void addExp(long amount) {}
    public long getExp() {return exp; }
    public long getExpToNextLevel() { return expToNextLevel; }
    public void levelUp() {}

    // 属性点
    public void addStr(int amount) {}
    public int getStr() { return strPoint; }
    public void addAgi(int amount) {}
    public int getAgi() { return agiPoint; }
    public void addVit(int amount) {}
    public int getVit() { return vitPoint; }
    public void addLuk(int amount) {}
    public int getLuk() { return lukPoint; }
    public void resetAttributePoints() {}

    // 属性
    public void setBaseStats(Stats stats) {
        this.baseStats = stats;
    }

    public void setBonusStats(Stats stats) {
        this.bonusStats = stats;
    }

    public void setFinalStats() {
        finalStats.setAttack(baseStats.getAttack() + bonusStats.getAttack());
    }




    // 战斗类

    // 当前生命
    public double getCurrentHp() {
        return currentHp;
    }

    // 造成伤害 等待战斗公式
    public void attack(Monster target) {
        target.takeDamage(finalStats.getAttack());
    }
    // 受到伤害
    public void takeDamage(double amount) {
        currentHp -= amount;
        if (currentHp <= 0) {currentHp = 0;}
    }
    // 恢满生命值
    public void healToFull() {
        currentHp = finalStats.getMaxHp();
    }
    // 是否死亡
    public boolean isDead() {
        return currentHp <= 0;
    }

    // 物品
    public void equip(Item item){}
    public void unEquip(Item item) {}
    public void addItem(Item item) {}
    public boolean hasItem(Item item) {return false;}

    // 职业
    public void chooseStar(Star star) {}

    public Star getStar() {return star;}

    public Stats getFinalStats() {return null;}

    public Stats getBaseStats() {
        return new Stats(100, 1, 1, 1, 1, 1, 1, 1);
    }
}
