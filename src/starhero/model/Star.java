package starhero.model;

public class Star {

    int id;
    String name;
    String description;
    Stats baseStats;

    /**
     * 构建函数
     * @param id id
     * @param name 名称
     * @param description 描述
     * @param baseStats 基础属性
     */
    public Star(int id, String name, String description, Stats baseStats) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.baseStats = baseStats;
    }
    public Star() {}


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Stats getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(Stats baseStats) {
        this.baseStats = baseStats;
    }
}
