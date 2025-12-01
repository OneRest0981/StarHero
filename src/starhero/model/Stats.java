package starhero.model;

public class Stats {


    // 防御相关
    private double maxHp;           // 最大生命
    private double armor;           // 护甲

    // 攻击相关
    private double attack;          // 攻击力
    private double attackSpeed;     // 攻击速度

    private double critChance;      // 暴击率
    private double critDamage;      // 暴击伤害

    // 资源相关
    private double goldBonus;       // 金币加成
    private double expBonus;        // 经验加成

    /**
     *
     * @param maxHp 最大生命
     * @param armor 护甲
     * @param attack 攻击伤害
     * @param attackSpeed 攻击速度
     * @param critChance 暴击几率
     * @param critDamage 暴击伤害
     * @param goldBonus 金币加成
     * @param expBonus 经验加成
     */
    public Stats (double maxHp, double armor, double attack, double attackSpeed, double critChance, double critDamage, double goldBonus, double expBonus) {
        this.maxHp = maxHp;
        this.armor = armor;
        this.attack = attack;
        this.attackSpeed = attackSpeed;
        this.critChance = critChance;
        this.critDamage = critDamage;
        this.goldBonus = goldBonus;
        this.expBonus = expBonus;
    }

    // 怪物用
    public Stats (double maxHp, double armor, double attack, double attackSpeed) {
        this.maxHp = maxHp;
        this.armor = armor;
        this.attack = attack;
        this.attackSpeed = attackSpeed;
    }

    public Stats () {}  // 无参构造

    // getter
    public double getMaxHp() {
        return maxHp;
    }
    public double getArmor() {
        return armor;
    }
    public double getAttack() {
        return attack;
    }
    public double getAttackSpeed() {
        return attackSpeed;
    }
    public double getCritChance() {
        return critChance;
    }
    public double getCritDamage() {
        return critDamage;
    }
    public double getGoldBonus() {
        return goldBonus;
    }

    public double getExpBonus() {
        return expBonus;
    }


    // Setter
    public void setMaxHp(double maxHp) {
        this.maxHp = maxHp;
    }
    public void setArmor(double armor) {
        this.armor = armor;
    }
    public void setAttack(double attack) {
        this.attack = attack;
    }
    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }
    public void setCritDamage(double critDamage) {
        this.critDamage = critDamage;
    }

    public void setGoldBonus(double goldBonus) {
        this.goldBonus = goldBonus;
    }
    public void setExpBonus(double expBonus) {
        this.expBonus = expBonus;
    }

    // Adder
    public void addMaxHp(double maxHp) {
        this.maxHp += maxHp;
    }
    public void addArmor(double armor) {
        this.armor += armor;
    }
    public void addAttack(double attack){
        this.attack += attack;
    }
    public void addAttackSpeed(double attackSpeed){
        this.attackSpeed += attackSpeed;
    }
    public void addCritChance(double critChance) {
        this.critChance += critChance;
    }
    public void addCritDamage(double critDamage) {
        this.critDamage += critDamage;
    }
    public void addGoldBonus(double goldBonus) {
        this.goldBonus += goldBonus;
    }
    public void addExpBonus (double expBonus) {
        this.expBonus += expBonus;
    }


    public void add(Stats other) {
        this.maxHp += other.maxHp;
        this.armor += other.armor;
        this.attack += other.attack;
        this.attackSpeed += other.attackSpeed;
        this.critDamage += other.critDamage;
        this.critChance += other.critChance;
        this.goldBonus += other.goldBonus;
        this.expBonus += other.expBonus;

    }
    public void clear(){};
}
