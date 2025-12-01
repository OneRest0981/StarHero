package starhero.model;

import java.math.BigDecimal;

public class Monster {

    private int id;
    private String name;
    private int level;
    private Stats stats;
    private double currentHP;
    private BigDecimal goldReward;
    private long expReward;
    private String spritePath;

    /**
     *
     * @param id id
     * @param name 名称
     * @param level 等级
     * @param stats 属性
     * @param goldReward 金币奖励
     * @param expReward 经验奖励
     */
    public Monster(int id, String name, int level, Stats stats, BigDecimal goldReward, long expReward, String spritePath) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.stats = stats;
        this.currentHP = stats.getMaxHp();
        this.goldReward = goldReward;
        this.expReward = expReward;
        this.spritePath = spritePath;
    }
    public Monster() {}


    // Getter Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public double getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(double currentHP) {
        this.currentHP = currentHP;
    }

    public BigDecimal getGoldReward() {
        return goldReward;
    }

    public void setGoldReward(BigDecimal goldReward) {
        this.goldReward = goldReward;
    }

    public long getExpReward() {
        return expReward;
    }

    public void setExpReward(long expReward) {
        this.expReward = expReward;
    }

    // 基础方法

    // 受伤
    public void takeDamage(double amount) {
        currentHP -= amount;
        if(currentHP <= 0){currentHP = 0;}
    }

    // 攻击
    public double attack(Player target) {

        double attack = stats.getAttack();
        double targetArmor = target.getFinalStats().getArmor();
        double damage = attack * 100.0 / (100.0 + targetArmor);
        return damage;
    }

    // 死亡
    public boolean isDead() {
        return this.currentHP <= 0;
    }

    // 重置生命
    public void resetHP() {
        this.currentHP = stats.getMaxHp();
    }

    // 获得贴图路径
    public String getSpritePath() {
        return this.spritePath;
    }
}
