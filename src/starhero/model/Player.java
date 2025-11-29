package starhero.model;

import java.math.BigDecimal;
import java.util.Random;

public class Player {

    // 信息
    private final int id;
    private final String name;

    // 等级经验
    private int level;
    private long exp;
    private long expToNextLevel;
    private BigDecimal gold = BigDecimal.valueOf(0);

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

        this.baseStats = new Stats();
        this.bonusStats = new Stats();
        this.finalStats = new Stats();

        this.currentHp = 1;
    }

    // 方法

    // 基础


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public void addGold(BigDecimal gold){
        this.gold = this.gold.add(gold);
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

    public void recalculateStats() {
        // 清空baseStats
        baseStats = new Stats();

        // Star 提供属性
        if (star != null)
            baseStats.add(star.getBaseStats());

        // 属性点属性
        baseStats.addMaxHp(vitPoint * 2);
        baseStats.addArmor(vitPoint * 2);
        baseStats.addAttack(strPoint *2);
        baseStats.addAttackSpeed(agiPoint * 0.001);
        baseStats.addCritChance(agiPoint * 0.1);
        baseStats.addCritDamage(strPoint * 0.1);
        baseStats.addGoldBonus(lukPoint * 0.1);
        baseStats.addExpBonus(lukPoint*0.1);

        // bonus额外属性

        // 最终属性 finalStats = baseStats + bonusStats
        finalStats = new Stats();
        finalStats.add(baseStats);
        finalStats.add(bonusStats); // TODO: 装备系统

        // 修正当前生命
        if (currentHp > finalStats.getMaxHp())
            currentHp = finalStats.getMaxHp();



    }



    // 战斗类

    // 当前生命
    public double getCurrentHp() {
        return currentHp;
    }

    // 造成伤害 等待战斗公式
    public double attack(Monster target) {

        double aDamage = finalStats.getAttack();
        double aCritChance = finalStats.getCritChance() / 100 + 1;
        double aCritDamage = finalStats.getCritDamage() / 100 + 1;

        double targetArmor = target.getStats().getArmor();

        // 基础伤害
        double defaultResult = aDamage * 100.0 / (100.0 + targetArmor);;

        // 暴击判定
        if(Math.random() < aCritChance) {
            double critDamage = defaultResult + defaultResult * aCritDamage;
            target.takeDamage(critDamage);
            return critDamage;
        }else {
            target.takeDamage(finalStats.getAttack());
            return finalStats.getAttack();

        }
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
    public void chooseStar(Star star) {
        this.star = star;
    }

    public Star getStar() { return star; }

    public Stats getFinalStats() { return finalStats; }

    public Stats getBaseStats() { return baseStats; }
}
