package starhero.model;

import java.math.BigDecimal;

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

    // 金币升级等级：每级 = +1%
    private int maxHpUpgradeLevel;
    private int armorUpgradeLevel;
    private int attackUpgradeLevel;
    private int attackSpeedUpgradeLevel;
    private int critChanceUpgradeLevel;
    private int critDamageUpgradeLevel;
    private int goldBonusUpgradeLevel;
    private int expBonusUpgradeLevel;

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

    // 金币属性
    public int getMaxHpUpgradeLevel() {
        return maxHpUpgradeLevel;
    }

    public void setMaxHpUpgradeLevel(int maxHpUpgradeLevel) {
        this.maxHpUpgradeLevel = maxHpUpgradeLevel;
    }

    public int getArmorUpgradeLevel() {
        return armorUpgradeLevel;
    }

    public void setArmorUpgradeLevel(int armorUpgradeLevel) {
        this.armorUpgradeLevel = armorUpgradeLevel;
    }

    public int getAttackUpgradeLevel() {
        return attackUpgradeLevel;
    }

    public void setAttackUpgradeLevel(int attackUpgradeLevel) {
        this.attackUpgradeLevel = attackUpgradeLevel;
    }

    public int getAttackSpeedUpgradeLevel() {
        return attackSpeedUpgradeLevel;
    }

    public void setAttackSpeedUpgradeLevel(int attackSpeedUpgradeLevel) {
        this.attackSpeedUpgradeLevel = attackSpeedUpgradeLevel;
    }

    public int getCritChanceUpgradeLevel() {
        return critChanceUpgradeLevel;
    }

    public void setCritChanceUpgradeLevel(int critChanceUpgradeLevel) {
        this.critChanceUpgradeLevel = critChanceUpgradeLevel;
    }

    public int getCritDamageUpgradeLevel() {
        return critDamageUpgradeLevel;
    }

    public void setCritDamageUpgradeLevel(int critDamageUpgradeLevel) {
        this.critDamageUpgradeLevel = critDamageUpgradeLevel;
    }

    public int getGoldBonusUpgradeLevel() {
        return goldBonusUpgradeLevel;
    }

    public void setGoldBonusUpgradeLevel(int goldBonusUpgradeLevel) {
        this.goldBonusUpgradeLevel = goldBonusUpgradeLevel;
    }

    public int getExpBonusUpgradeLevel() {
        return expBonusUpgradeLevel;
    }

    public void setExpBonusUpgradeLevel(int expBonusUpgradeLevel) {
        this.expBonusUpgradeLevel = expBonusUpgradeLevel;
    }

    private BigDecimal calcUpgradeCost(int currentLevel) {
        // 举例：基础 100 金币，每级涨 15%
        double base = 5;
        double ratio = 1.15;
        return BigDecimal.valueOf(Math.round(base * Math.pow(ratio, currentLevel)));
    }

    // 最大生命
    public boolean upgradeMaxHpWithGold() {
        BigDecimal cost = calcUpgradeCost(maxHpUpgradeLevel);
        if (gold.compareTo(cost) < 0) {
            return false;
        }
        this.gold = gold.subtract(cost);
        maxHpUpgradeLevel++;

        recalculateStats();
        return true;
    }

    // 护甲
    public boolean upgradeArmorWithGold() {
        BigDecimal cost = calcUpgradeCost(armorUpgradeLevel);
        if (gold.compareTo(cost) < 0) {
            return false;
        }
        this.gold = gold.subtract(cost);
        armorUpgradeLevel++;

        recalculateStats();
        return true;
    }

    // 攻击伤害
    public boolean upgradeAttackWithGold() {
        BigDecimal cost = calcUpgradeCost(attackUpgradeLevel);
        if (gold.compareTo(cost) < 0) {
            return false;
        }
        this.gold = gold.subtract(cost);
        attackUpgradeLevel++;

        recalculateStats();
        return true;
    }

    // 攻击速度
    public boolean upgradeAttackSpeedWithGold() {
        BigDecimal cost = calcUpgradeCost(attackSpeedUpgradeLevel);
        if (gold.compareTo(cost) < 0) {
            return false;
        }
        this.gold = gold.subtract(cost);
        attackSpeedUpgradeLevel++;

        recalculateStats();
        return true;
    }

    // 暴击几率
    public boolean upgradeCritChanceWithGold() {
        BigDecimal cost = calcUpgradeCost(critChanceUpgradeLevel);
        if (gold.compareTo(cost) < 0) {
            return false;
        }
        this.gold = gold.subtract(cost);
        critChanceUpgradeLevel++;

        recalculateStats();
        return true;
    }

    // 暴击伤害
    public boolean upgradeCritDamageWithGold() {
        BigDecimal cost = calcUpgradeCost(critDamageUpgradeLevel);
        if (gold.compareTo(cost) < 0) {
            return false;
        }
        this.gold = gold.subtract(cost);
        critDamageUpgradeLevel++;

        recalculateStats();
        return true;
    }

    // 金币加成
    public boolean upgradeGoldBonusWithGold() {
        BigDecimal cost = calcUpgradeCost(goldBonusUpgradeLevel);
        if (gold.compareTo(cost) < 0) {
            return false;
        }
        this.gold = gold.subtract(cost);
        goldBonusUpgradeLevel++;

        recalculateStats();
        return true;
    }

    // 经验加成
    public boolean upgradeExpBonusWithGold() {
        BigDecimal cost = calcUpgradeCost(expBonusUpgradeLevel);
        if (gold.compareTo(cost) < 0) {
            return false;
        }
        this.gold = gold.subtract(cost);
        expBonusUpgradeLevel++;

        recalculateStats();
        return true;
    }




    // 属性点
    public int getStr() { return strPoint; }
    public int getAgi() { return agiPoint; }
    public int getVit() { return vitPoint; }
    public int getLuk() { return lukPoint; }

    public void addStr(int amount) {
        this.strPoint += amount;
        recalculateStats();
    }

    public void addAgi(int amount) {
        this.agiPoint += amount;
        recalculateStats();}

    public void addVit(int amount) {
        this.vitPoint += amount;
        recalculateStats();}

    public void addLuk(int amount) {
        this.lukPoint += amount;
        recalculateStats();}


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
        baseStats.mul(new Stats(maxHpUpgradeLevel, armorUpgradeLevel, attackUpgradeLevel, attackSpeedUpgradeLevel, critChanceUpgradeLevel, critDamageUpgradeLevel, goldBonusUpgradeLevel, expBonusUpgradeLevel));

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
