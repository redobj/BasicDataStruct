package data_struct.linear_structure.linear_list;

/**
 * 顺序表
 * @param <T> T表示要存储的数据类型
 */
public class SeqList<T> {
    //底层数组
    protected Object[] elements;
    //顺序表长度
    protected int size;

    /**
     * 输入顺序表长度构造
     * @param length
     */
    public SeqList(int length){
        if(length < 0){
            //抛出数组负数异常
            throw new NegativeArraySizeException();
        }
        this.elements = new Object[length];
        this.size = 0;
    }

    public SeqList(){
        //新建默认数组
        this.elements = new Object[64];
        this.size = 0;
    }

    /**
     * 从数组中新建顺序表
     * @param values
     */
    public SeqList(T values[]){
        this(values.length);
        for (int i = 0; i < values.length; i++) {
            elements[i] = values[i];
        }
        this.size = elements.length;
    }

    /**
     * 检查顺序表是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * 返回元素个数
     * @return
     */
    public int size(){
        return this.size;
    }

    /**
     * 设置元素
     * @param i
     * @param obj
     */
    public void set(int i, T obj){
        if(obj == null){
            //抛出空指针异常
            throw new NullPointerException();
        }
        if(i>=0 && i< size){
            elements[i] = obj;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * 在指定位置插入元素 ，并返回插入位置
     * @param i
     * @param obj
     * @return
     */
    public int insert(int i, T obj){
        if(obj == null){
            throw new NullPointerException();
        }

        //容错处理 位置比0小，则插入elements[0]
        if(i < 0){
            i = 0;
        }
        //位置比size大，则插入elements[size];
        if(i > size){
            i = size;
        }

        Object[] src = this.elements;

        //如果表已满，申请更大空间并转移元素
        if(size == src.length){
            this.elements = new Object[src.length * 2];
            for (int j = 0;j<src.length;j++){
                elements[j] = src[j];
            }
        }

        for(int j = size-1;j>=i;j--){
            this.elements[j+1] = this.elements[j];
        }

        this.elements[i] = obj;
        this.size++;
        return i;
    }

    //表尾插入元素，重载方法
    public int insert(T obj){
        return this.insert(size,obj);
    }

    //删除元素
    public T remove(int index){
        T old = (T) elements[index];
        //后面元素向前移动
        if(size > 0 && index >= 0 && index < size){
            for (int i = index; i < size; i++) {
                elements[i] = elements[i+1];
            }
            //清除空间
            elements[size-1] = null;
            size--;
            return old;
        }else{
            return null;
        }
    }

    //清空顺序表
    public void clear(){
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]+",");
        }
        return sb.toString().trim();
    }
}
