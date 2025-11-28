package starhero.model;

import java.math.BigDecimal;

public class Player {

    // 信息
    private int id;
    private String name;

    // 等级经验
    private int level;
    private long exp;
    private long maxExp;

    // 星星 职业
    private Star star;

    // 属性点
    private int strPoint;
    private int agiPoint;
    private int vitPoint;
    private int lukPoint;
    private int freePoints;

    // 属性结构
    private Stats baseStats;
    private Stats bounsStats;
    private Stats finalStats;

    // 战斗状态
    private double currentHp;

    // 背包
    private Inventory inventory;

    // 装备栏
    private Item weapon;
    private Item helmet;
    private Item chestplate;
    private Item Leggings;
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

    // 升级
    public void addExp(long amount) {}
    public void levelUp() {}

    // 属性点
    public void addStr(int amount) {}
    public void addAgi(int amount) {}
    public void addVit(int amount) {}
    public void addLuk(int amount) {}

    // 属性重置
    public void resetAttributePoints() {}

    // 战斗
    public void toDamage(long count) {}
    public void fullHp() {}
    public boolean isDeath() {return false;}

    // 物品
    public void equip(Item item){}
    public void unEquip(Item item) {}
    public void addItem(Item item) {}
    public boolean hasItem(Item item) {return false;}

    // 职业
    public void chooseStar(Star star) {}

    public Star getStar() {return star;}

}
