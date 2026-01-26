package base;

public abstract class BaseEntity {

    protected int id;

    public BaseEntity(int id) {
        this.id = id;
    }


    public abstract String getEntityType();
    public abstract void printInfo();
    public int getId() {
        return id;
    }
}
