package starhero.model;

public class Item {

    int id;
    String name;
    ItemType itemType;
    Stats stats;
    String description;

    /**
     * 装备用
     * @param id id
     * @param name 物品名
     * @param itemType 物品类型
     * @param stats 属性
     * @param description 物品描述
     */
    public Item(int id, String name, ItemType itemType, Stats stats, String description) {
        this.id = id;
        this.name = name;
        this.itemType = itemType;
        this.stats = stats;
        this.description = description;
    }

    /**
     * 材料用
     * @param id id
     * @param name 物品名
     * @param itemType 物品类型
     * @param description 物品描述
     */
    public Item(int id, String name, ItemType itemType, String description) {
        this.id = id;
        this.name = name;
        this.itemType = itemType;
        this.description = description;
    }



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

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
