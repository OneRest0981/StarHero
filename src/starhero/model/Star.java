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




}
